package org.restaurant;

import java.util.LinkedList;
import java.util.Objects;

public class OrderHandler  {
    private LinkedList<Orders> orderResults = new LinkedList<>();

    private OrderHandler() {

    }

    private static class PollVo {
        private final Orders orders;
        private final LinkedList<Orders> copyResult;

        private PollVo(Orders orders, LinkedList<Orders> copyResult) {
            this.orders = orders;
            this.copyResult = copyResult;
        }

        public static PollVo newInstance(Orders orders, LinkedList<Orders> copyResult) {
            return new PollVo(orders, copyResult);
        }

        public Orders getOrders() {
            return orders;
        }

        public LinkedList<Orders> getCopyResult() {
            return copyResult;
        }
    }

    public static OrderHandler newInstance() {
        return new OrderHandler();
    }

    public boolean isComplete(){
        return !orderResults.isEmpty();
    }
    public Orders process() {
        return complete(requestProcess()).orders;
    }
    public Orders requestIn(Orders orders) {
        PollVo pollVo = insertRequest(orders);
        return complete(pollVo).getOrders();
    }

    private PollVo complete(PollVo pollVo) {
        orderResults = pollVo.getCopyResult();
        return pollVo;
    }

    private PollVo insertRequest(Orders orders) {
        LinkedList<Orders> copyOrderForOffer = copyOrder();
        copyOrderForOffer.offer(orders);
        return complete(PollVo.newInstance(orders, copyOrderForOffer));
    }

    private PollVo requestProcess() {
        LinkedList<Orders> safeCopy = copyOrder();
        return complete(PollVo.newInstance(safeCopy.poll(), safeCopy));
    }

    private LinkedList<Orders> copyOrder() {
        return (LinkedList<Orders>) orderResults.clone();
    }


    @Override
    public int hashCode() {
        return Objects.hash(orderResults);
    }


}

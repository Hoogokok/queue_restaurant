package org.restaurant;

import static org.restaurant.InputView.*;

public class Main {
    //1. 주문요청 2. 주문처리 3. 매출액 총액 4. 종료
    public static void main(String[] args) {

        SalesManager manager = SalesManager.manager();
        OrderHandler orderHandler = OrderHandler.newInstance();

        while (true) {
            orderGuide();
            String button = orderButton();
            if (button.equals("1")) {
                do {
                    Orders orders = printInputOrders(printInputFood());
                    orderHandler.requestIn(orders);
                } while (!InputView.orderQuiet().equals("q"));
            }
            if (button.equals("2")) {
                System.out.println("주문 처리를 시작합니다.");
                do {
                    manager.completeOrder(orderHandler.process());
                } while (orderHandler.isComplete());
                System.out.println(manager);
            }

            if (button.equals("3")) {
                System.out.println(manager.totalSum());
            }

            if (button.equals("4")) {
                return;
            }
        }
    }

    public static OrderHandler readRequestOrders(OrderHandler orderHandler) {
        return new InputProcessor<>(() -> {
            try {
                do {
                    Orders orders = printInputOrders(printInputFood());
                    orderHandler.requestIn(orders);
                } while (!orderQuiet().matches("q"));
                return orderHandler;
            } catch (Exception e) {
                e.printStackTrace();
                throw new IllegalArgumentException();
            }
        }).process();
    }

}

package org.restaurant;

import java.util.LinkedList;

public class SalesManager {
    private final LinkedList<Orders> finishOrders = new LinkedList<>();

    private SalesManager() {
    }

    public static SalesManager manager() {
        return new SalesManager();
    }

    public void completeOrder(Orders orders) {
        finishOrders.add(orders);
    }

    public Integer totalSum() {
        return finishOrders.stream().map(orders -> orders.getFood().getPrice() * orders.getAmount())
                .reduce(Integer::sum).orElse(0);
    }

    @Override
    public String toString() {
        return "OrderRequestManager{" +
                "finishOrders=" + finishOrders +
                '}';
    }
}

package org.restaurant;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderManagerTest {

    @Test
    void totalSum() {
        Orders foodOder = Orders.from(Food.newInstance("비빔밥", 1200), 1);
        Orders foodOder2 = Orders.from(Food.newInstance("요거트", 1000), 1);


        OrderHandler orderHandler = OrderHandler.newInstance();
        orderHandler.requestIn(foodOder);
        orderHandler.requestIn(foodOder2);
        SalesManager orderResultManager = SalesManager.manager();

        orderResultManager.completeOrder(orderHandler.process());
        orderResultManager.completeOrder(orderHandler.process());
        Integer reduce = orderResultManager.totalSum();
        assertThat(reduce).isEqualTo(2200);
    }

}

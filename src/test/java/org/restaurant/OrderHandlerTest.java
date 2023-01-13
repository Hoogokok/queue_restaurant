package org.restaurant;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderHandlerTest {
    @Test
    void cokingRequestComplete() {
        //given

        Orders foodOder = Orders.from(Food.newInstance("비빔밥", 1234), 1);
        Orders foodOder2 = Orders.from(Food.newInstance("요거트", 1234), 1);


        OrderHandler orderHandler = OrderHandler.newInstance();
        //when
        orderHandler.requestIn(foodOder);
        orderHandler.requestIn(foodOder2);
        Orders order = orderHandler.process();
        Orders order2 = orderHandler.process();
        //then
        assertThat(order).isEqualTo(foodOder);
        assertThat(order2).isEqualTo(foodOder2);
    }
}

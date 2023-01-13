package org.restaurant;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class OrderTest {

    @Test
    void takeOrder() {
        Food bob = Food.newInstance("bob", 100000);

        Orders order1 = Orders.from(bob, 1);

        assertAll(() -> assertThat(order1.getFood()).isIn(bob),
                () -> assertThat(order1.getAmount()).isEqualTo(1));
    }
}

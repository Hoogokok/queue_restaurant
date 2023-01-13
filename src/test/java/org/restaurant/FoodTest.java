package org.restaurant;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class FoodTest {
    @Test
    void getFoodName() {
      Food chicken  = Food.newInstance("chicken",10000);

      assertAll( () -> assertThat(chicken.getFoodName()).isEqualTo("chicken"),
              () -> assertThat(chicken.getPrice()).isEqualTo(10000));
    }
}
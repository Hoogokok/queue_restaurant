package org.restaurant;

import java.util.Objects;

public class Orders {
    private final Food food;
    private final int amount;

    private Orders(Food food, int amount) {
        this.food = food;
        this.amount = amount;
    }

    public static Orders from(Food food, int amount) {
        return new Orders(food, amount);
    }

    public Food getFood() {
        return food;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orders orders = (Orders) o;
        return amount == orders.amount && Objects.equals(food, orders.food);
    }

    @Override
    public int hashCode() {
        return Objects.hash(food, amount);
    }

    @Override
    public String toString() {
        return "Orders{" +
                "food=" + food +
                ", amount=" + amount +
                '}';
    }
}

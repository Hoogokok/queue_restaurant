package org.restaurant;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Food {
    private static final Map<String, Food> FIXED_MENU = new HashMap<>();

    static {
        FIXED_MENU.put("참치김밥", Food.newInstance("참치김밥", 3500));
        FIXED_MENU.put("라면", Food.newInstance("라면", 4500));
        FIXED_MENU.put("김치볶음밥", Food.newInstance("김치볶음밥", 5500));
    }

    private final String foodName;
    private final Integer price;


    private Food(String foodName, Integer price) {
        this.foodName = foodName;
        this.price = price;
    }

    public static Food newInstance(String foodName, Integer price) {
        return new Food(foodName, price);
    }

    public static Food fixedMenu(String foodName) {
        return FIXED_MENU.get(foodName);
    }

    public String getFoodName() {
        return foodName;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Food food = (Food) o;
        return price == food.price && Objects.equals(foodName, food.foodName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(foodName, price);
    }

    @Override
    public String toString() {
        return "Food{" + "foodName='" + foodName + '\'' + ", price=" + price + '}';
    }
}

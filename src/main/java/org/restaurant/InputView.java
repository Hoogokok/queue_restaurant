package org.restaurant;

import java.util.Scanner;

public class InputView {
    private static final Scanner sc = new Scanner(System.in);

    public static Food printInputFood() {
        System.out.println("음식을 입력해주세요.");
        String name = sc.nextLine();
        System.out.println("가격을 입력해주세요");
        String price = sc.nextLine();

        return Food.newInstance(name, Integer.valueOf(price));
    }

    public static Orders printInputOrders(Food food) {
        System.out.println("양을 입력해주세요");
        String amount = sc.nextLine();

        return Orders.from(food,Integer.parseInt(amount));
    }

    public static String orderQuiet() {
        System.out.println("주문이 끝났다면 q버튼을 눌러주세요.");

        return sc.nextLine();
    }

    public static void orderGuide() {
        System.out.println("1. 주문요청  2. 주문처리 3. 매출액 총액 4. 종료");
    }

    public static String orderButton(){
        return sc.nextLine();
    }
}

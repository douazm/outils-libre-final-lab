package org.example;

public class PricingEngine {
    public static void main(String[] args) {
        double[] prices = {100, 50, 25};
        int[] quantities = {2, 1, 4};
        String customerType = "VIP";
        String discountCode = "SAVE10";

        double subtotal = 0;
        for (int i = 0; i < prices.length; i++) {
            subtotal += prices[i] * quantities[i];
        }

        double discount = 0;
        if (discountCode.equals("SAVE10")) {
            discount = subtotal * 0.10;
        } else if (discountCode.equals("SAVE20")) {
            discount = subtotal * 0.20;
        }

        if (customerType.equals("VIP")) {
            discount += subtotal * 0.05;
        }

        double tax = (subtotal - discount) * 0.19;
        double finalPrice = subtotal - discount + tax;

        System.out.println("Subtotal: " + subtotal);
        System.out.println("Discount: " + discount);
        System.out.println("Tax: " + tax);
        System.out.println("Final Price: " + finalPrice);
    }
}

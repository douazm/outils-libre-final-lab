package org.example;

public class PricingEngine {
    public static void main(String[] args) {
        double[] prices = {100, 50, 25};
        int[] quantities = {2, 1, 4};
        String customerType = "VIP";
        String discountCode = "SAVE10";

        // حساب Subtotal
        double subtotal = 0;
        for (int i = 0; i < prices.length; i++) {
            subtotal += prices[i] * quantities[i];
        }

        // استخدام الخدمة الجديدة للخصومات
        DiscountService discountService = new DiscountService();
        double discount = discountService.calculateDiscount(subtotal, customerType, discountCode);

        // حساب الضريبة
        double tax = (subtotal - discount) * 0.19;

        // السعر النهائي
        double finalPrice = subtotal - discount + tax;

        // المخرجات
        System.out.println("Subtotal: " + subtotal);
        System.out.println("Discount: " + discount);
        System.out.println("Tax: " + tax);
        System.out.println("Final Price: " + finalPrice);
    }
}


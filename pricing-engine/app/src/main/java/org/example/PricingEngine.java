package org.example;

public class PricingEngine {

    public double calculateFinalPrice(double subtotal,
                                      String customerType,
                                      String discountCode) {

        double discount = 0;

        // VIP discount
        if (customerType.equals("VIP")) {
            discount += subtotal * 0.10;
        }

        // Discount code
        if (discountCode.equals("SAVE20")) {
            discount += subtotal * 0.20;
        }

        double afterDiscount = subtotal - discount;

        // Tax
        double tax = afterDiscount * 0.07;

        return afterDiscount + tax;
    }
}
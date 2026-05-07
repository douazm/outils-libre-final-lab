package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PricingEngineTest {

    @Test
    void testSubtotalCalculation() {
        double[] prices = {100, 50};
        int[] quantities = {2, 1};
        double subtotal = 0;
        for (int i = 0; i < prices.length; i++) {
            subtotal += prices[i] * quantities[i];
        }
        assertEquals(250, subtotal, 0.01);
    }

    @Test
    void testDiscountWithSave10() {
        DiscountService discountService = new DiscountService();
        double subtotal = 200;
        double discount = discountService.calculateDiscount(subtotal, "REGULAR", "SAVE10");
        assertEquals(20, discount, 0.01);
    }

    @Test
    void testTaxCalculation() {
        TaxService taxService = new TaxService();
        double subtotal = 200;
        double discount = 20;
        double tax = taxService.calculateTax(subtotal, discount);
        assertEquals((200 - 20) * 0.19, tax, 0.01);
    }

    @Test
    void testFinalPrice() {
        double subtotal = 200;
        double discount = 20;
        double tax = (subtotal - discount) * 0.19;
        double finalPrice = subtotal - discount + tax;
        assertEquals(200 - 20 + tax, finalPrice, 0.01);
    }
}

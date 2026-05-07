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
}

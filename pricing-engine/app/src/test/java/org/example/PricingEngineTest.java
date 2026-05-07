package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PricingEngineTest {

    @Test
    void testVIPDiscount() {

        PricingEngine engine = new PricingEngine();

        double result = engine.calculateFinalPrice(
                200.0,
                "VIP",
                "SAVE20"
        );

        assertEquals(149.8, result, 0.01);
    }

    @Test
    void testRegularCustomer() {

        PricingEngine engine = new PricingEngine();

        double result = engine.calculateFinalPrice(
                100.0,
                "REGULAR",
                ""
        );

        assertEquals(107.0, result, 0.01);
    }
}

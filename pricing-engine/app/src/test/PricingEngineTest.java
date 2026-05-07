package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class PricingEngineTest {
    @Test
    void testBasicCalculation() {
        PricingEngine engine = new PricingEngine();
        double result = engine.calc(List.of(100.0), List.of(2), "REGULAR", "");
        assertEquals(238.0, result, 0.01);
    }

    @Test
    void testVIPDiscount() {
        PricingEngine engine = new PricingEngine();
        double result = engine.calc(List.of(100.0), List.of(1), "VIP", "");
        assertEquals(107.1, result, 0.01);
    }
}
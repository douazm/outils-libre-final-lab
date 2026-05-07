package org.example;

public class TaxService {

    public double calculateTax(double subtotal, double discount) {
        return (subtotal - discount) * 0.19;
    }
}


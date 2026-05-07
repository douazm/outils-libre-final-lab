public class Main {
    public static void main(String[] args) {
        double originalPrice = 200.0;
        double discount = 0.10; // خصم 10%
        double finalPrice = originalPrice - (originalPrice * discount);

        System.out.println("=== Pricing Engine Summary ===");
        System.out.println("Original Price: " + originalPrice + " DA");
        System.out.println("Final Price after Discount: " + finalPrice + " DA");
    }
}
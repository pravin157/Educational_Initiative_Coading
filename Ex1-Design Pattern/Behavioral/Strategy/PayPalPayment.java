package behavioral.strategy;

// Concrete Strategy - PayPal Payment
public class PayPalPayment implements PaymentStrategy {
    private final String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    public boolean pay(PaymentDetails details) {
        if (details.amountCents <= 0) return false;
        System.out.printf("Processing PayPal payment for %s amount: $%.2f\n", email, details.amountCents / 100.0);
        return true;
    }
}
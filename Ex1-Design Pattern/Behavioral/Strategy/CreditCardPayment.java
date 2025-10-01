package behavioral.strategy;

// Concrete Strategy - Credit Card Payment
public class CreditCardPayment implements PaymentStrategy {
    private final String cardNumber; 
    private final String cardHolder;

    public CreditCardPayment(String cardNumber, String cardHolder) {
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
    }

    private String maskPan(String pan) {
        if (pan == null) return "****";
        int len = pan.length();
        if (len <= 4) return pan;
        return "**** **** **** " + pan.substring(len - 4);
    }

    public boolean pay(PaymentDetails details) {
        if (details.amountCents <= 0) return false;
        System.out.printf("Charging %s (card: %s) amount: $%.2f\n",
            cardHolder, maskPan(cardNumber), details.amountCents / 100.0);
        return true;
    }
}
package behavioral;

import java.util.*;
import java.util.regex.*;
// Strategy Interface
interface PaymentStrategy {
    boolean pay(PaymentDetails details);
}
// Payment details holder
class PaymentDetails {
    public final int amountCents;
    public final Map<String, String> metadata;

    public PaymentDetails(int amountCents) {
        this.amountCents = amountCents;
        this.metadata = new HashMap<>();
    }
}
// Concrete Strategies

class CreditCardPayment implements PaymentStrategy {
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
// Concrete Strategies
class PayPalPayment implements PaymentStrategy {
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
// Shopping Cart
class ShoppingCart {
    private final List<CartItem> items = new ArrayList<>();
    private PaymentStrategy strategy;

    static class CartItem { final String name; final int priceCents; CartItem(String n, int p){name=n;priceCents=p;} }

    public void addItem(String name, int priceCents) { items.add(new CartItem(name, priceCents)); }

    public int totalCents() { return items.stream().mapToInt(i -> i.priceCents).sum(); }

    public void setPaymentStrategy(PaymentStrategy strategy) { this.strategy = strategy; }

    public boolean checkout() {
        if (strategy == null) throw new IllegalStateException("No payment strategy set");
        int total = totalCents();
        PaymentDetails details = new PaymentDetails(total);
        return strategy.pay(details);
    }
}
// Demo
public class StrategyDemo {
    public static void run() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Book: Clean Code", 2999);
        cart.addItem("USB-C Cable", 1299);

        cart.setPaymentStrategy(new CreditCardPayment("4111111111111412", "Alice"));
        boolean ok = cart.checkout();
        System.out.println("Credit card checkout successful: " + ok);

    
        ShoppingCart cart2 = new ShoppingCart();
        cart2.addItem("Pro Subscription", 9999);
        cart2.setPaymentStrategy(new PayPalPayment("pravinprakash012.com"));
        System.out.println("PayPal checkout successful: " + cart2.checkout());
    }
}

package behavioral.strategy;

// Demo class for Strategy pattern
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
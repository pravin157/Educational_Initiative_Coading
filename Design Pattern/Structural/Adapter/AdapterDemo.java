package structural.adapter;

// Demo class for Adapter pattern
public class AdapterDemo {
    public static void run() {
        PaymentProcessor ccPayment = new CreditCardProcessor();
        PaymentProcessor paypalPayment = new PayPalAdapter();

        ccPayment.pay(50);
        paypalPayment.pay(100);
    }
}
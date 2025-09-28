package structural.adapter;

// Credit Card Processor
public class CreditCardProcessor implements PaymentProcessor {
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using Credit Card");
    }
}
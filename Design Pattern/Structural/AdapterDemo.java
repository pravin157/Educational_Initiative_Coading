package structural;

// Existing Payment Interface
interface PaymentProcessor {
    void pay(double amount);
}

// Credit Card Processor
class CreditCardProcessor implements PaymentProcessor {
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using Credit Card");
    }
}

// PayPal Service (incompatible interface)
class PayPalService {
    public void makePayment(double money) {
        System.out.println("Paid $" + money + " using PayPal");
    }
}

// Adapter to fit PayPal into PaymentProcessor
class PayPalAdapter implements PaymentProcessor {
    private PayPalService service = new PayPalService();
    public void pay(double amount) {
        service.makePayment(amount);
    }
}

// Demo
public class AdapterDemo {
    public static void run() {
        PaymentProcessor ccPayment = new CreditCardProcessor();
        PaymentProcessor paypalPayment = new PayPalAdapter();

        ccPayment.pay(50);
        paypalPayment.pay(100);
    }
}

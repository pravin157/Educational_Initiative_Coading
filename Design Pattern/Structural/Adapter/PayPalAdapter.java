package structural.adapter;

// Adapter to fit PayPal into PaymentProcessor
public class PayPalAdapter implements PaymentProcessor {
    private PayPalService service = new PayPalService();
    
    public void pay(double amount) {
        service.makePayment(amount);
    }
}
package structural.adapter;

// PayPal Service (incompatible interface)
public class PayPalService {
    public void makePayment(double money) {
        System.out.println("Paid $" + money + " using PayPal");
    }
}
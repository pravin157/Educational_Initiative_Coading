package behavioral.strategy;

// Strategy Interface
public interface PaymentStrategy {
    boolean pay(PaymentDetails details);
}
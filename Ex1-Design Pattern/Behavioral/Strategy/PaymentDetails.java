package behavioral.strategy;

import java.util.*;

// Payment details holder
public class PaymentDetails {
    public final int amountCents;
    public final Map<String, String> metadata;

    public PaymentDetails(int amountCents) {
        this.amountCents = amountCents;
        this.metadata = new HashMap<>();
    }
}
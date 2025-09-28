package behavioral.strategy;

import java.util.*;

// Shopping Cart Context
public class ShoppingCart {
    private final List<CartItem> items = new ArrayList<>();
    private PaymentStrategy strategy;

    public static class CartItem { 
        final String name; 
        final int priceCents; 
        
        CartItem(String n, int p) {
            name = n;
            priceCents = p;
        } 
    }

    public void addItem(String name, int priceCents) { 
        items.add(new CartItem(name, priceCents)); 
    }

    public int totalCents() { 
        return items.stream().mapToInt(i -> i.priceCents).sum(); 
    }

    public void setPaymentStrategy(PaymentStrategy strategy) { 
        this.strategy = strategy; 
    }

    public boolean checkout() {
        if (strategy == null) throw new IllegalStateException("No payment strategy set");
        int total = totalCents();
        PaymentDetails details = new PaymentDetails(total);
        return strategy.pay(details);
    }
}
package creational.factory;

import java.time.Instant;

// Concrete SMS Notifier
public class SMSNotifier implements Notifier {
    public void send(String to, String message) {
        System.out.printf("[%s] SMS -> %s: %s\n", Instant.now().toString(), to, message);
    }
}
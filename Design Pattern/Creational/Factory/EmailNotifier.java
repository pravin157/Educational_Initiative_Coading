package creational.factory;

import java.time.Instant;

// Concrete Email Notifier
public class EmailNotifier implements Notifier {
    public void send(String to, String message) {
        System.out.printf("[%s] Email -> %s: %s\n", Instant.now().toString(), to, message);
    }
}
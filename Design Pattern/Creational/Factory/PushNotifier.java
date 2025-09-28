package creational.factory;

import java.time.Instant;

// Concrete Push Notifier
public class PushNotifier implements Notifier {
    public void send(String to, String message) {
        System.out.printf("[%s] Push -> %s: %s\n", Instant.now().toString(), to, message);
    }
}
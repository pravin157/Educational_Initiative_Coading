package creational;

import java.time.Instant;

// Notifier interface and implementations
interface Notifier {
    void send(String to, String message);
}

class EmailNotifier implements Notifier {
    public void send(String to, String message) {
        System.out.printf("[%s] Email -> %s: %s\n", Instant.now().toString(), to, message);
    }
}

class SMSNotifier implements Notifier {
    public void send(String to, String message) {
        System.out.printf("[%s] SMS -> %s: %s\n", Instant.now().toString(), to, message);
    }
}

class PushNotifier implements Notifier {
    public void send(String to, String message) {
        System.out.printf("[%s] Push -> %s: %s\n", Instant.now().toString(), to, message);
    }
}

enum NotifierType { EMAIL, SMS, PUSH }

class NotifierFactory {
    public static Notifier getNotifier(NotifierType type) {
        switch (type) {
            case EMAIL: return new EmailNotifier();
            case SMS: return new SMSNotifier();
            case PUSH: return new PushNotifier();
            default: throw new IllegalArgumentException("Unsupported notifier type: " + type);
        }
    }
}

public class FactoryDemo {
    public static void run() {
        Notifier email = NotifierFactory.getNotifier(NotifierType.EMAIL);
        Notifier sms = NotifierFactory.getNotifier(NotifierType.SMS);
        Notifier push = NotifierFactory.getNotifier(NotifierType.PUSH);

        email.send("Subbusanthosh30@gmail.com", "Welcome to our service!");
        sms.send("+91 9787020747", "Your code is 123456");
        push.send("device-token-xyz", "You have a new message");
    }
}
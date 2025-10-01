package creational.factory;

// Factory for creating Notifiers
public class NotifierFactory {
    public static Notifier getNotifier(NotifierType type) {
        switch (type) {
            case EMAIL: return new EmailNotifier();
            case SMS: return new SMSNotifier();
            case PUSH: return new PushNotifier();
            default: throw new IllegalArgumentException("Unsupported notifier type: " + type);
        }
    }
}
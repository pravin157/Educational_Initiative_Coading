package creational.factory;

// Demo class for Factory pattern
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
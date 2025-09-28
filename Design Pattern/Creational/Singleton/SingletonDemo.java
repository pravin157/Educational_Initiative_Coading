package creational.singleton;

import creational.factory.*;

// Demo class for Singleton pattern
public class SingletonDemo {
    public static void run() {
        MessageBroker broker = MessageBroker.getInstance();

        Notifier email = NotifierFactory.getNotifier(NotifierType.EMAIL);
        Notifier sms = NotifierFactory.getNotifier(NotifierType.SMS);

        broker.dispatch(email, "pravinprakash@gmail.com", "Alert: Your report is ready");
        broker.dispatch(sms, "+91 8838140489", "Alert: Low balance");

        // allow some time for async tasks to run in this demo
        try { 
            Thread.sleep(500); 
        } catch (InterruptedException ignored) {}

        broker.shutdown();
    }
}
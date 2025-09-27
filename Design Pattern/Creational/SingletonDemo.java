package creational;

import java.util.concurrent.*;
import java.time.Instant;

// MessageBroker is a singleton responsible for dispatching notifications.
class MessageBroker {
    private final ExecutorService executor = Executors.newFixedThreadPool(4);

    private MessageBroker() {}

    private static class Holder { static final MessageBroker INSTANCE = new MessageBroker(); }

    public static MessageBroker getInstance() { return Holder.INSTANCE; }

    public void dispatch(Notifier notifier, String to, String message) {
        executor.submit(() -> {
            String ts = Instant.now().toString();
            System.out.printf("[%s] Dispatching via %s to %s\n", ts, notifier.getClass().getSimpleName(), to);
            notifier.send(to, message);
        });
    }

    public void shutdown() {
        executor.shutdown();
        try { executor.awaitTermination(5, TimeUnit.SECONDS); } catch (InterruptedException ignored) {}
    }
}

public class SingletonDemo {
    public static void run() {
        MessageBroker broker = MessageBroker.getInstance();

        Notifier email = NotifierFactory.getNotifier(NotifierType.EMAIL);
        Notifier sms = NotifierFactory.getNotifier(NotifierType.SMS);

        broker.dispatch(email, "pravinprakash@gmail.com", "Alert: Your report is ready");
        broker.dispatch(sms, "+91 8838140489", "Alert: Low balance");

        // allow some time for async tasks to run in this demo
        try { Thread.sleep(500); } catch (InterruptedException ignored) {}

        broker.shutdown();
    }
}

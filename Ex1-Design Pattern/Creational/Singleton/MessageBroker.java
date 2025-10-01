package creational.singleton;

import creational.factory.*;
import java.util.concurrent.*;
import java.time.Instant;

// MessageBroker is a singleton responsible for dispatching notifications.
public class MessageBroker {
    private final ExecutorService executor = Executors.newFixedThreadPool(4);

    private MessageBroker() {}

    private static class Holder { 
        static final MessageBroker INSTANCE = new MessageBroker(); 
    }

    public static MessageBroker getInstance() { 
        return Holder.INSTANCE; 
    }

    public void dispatch(Notifier notifier, String to, String message) {
        executor.submit(() -> {
            String ts = Instant.now().toString();
            System.out.printf("[%s] Dispatching via %s to %s\n", ts, notifier.getClass().getSimpleName(), to);
            notifier.send(to, message);
        });
    }

    public void shutdown() {
        executor.shutdown();
        try { 
            executor.awaitTermination(5, TimeUnit.SECONDS); 
        } catch (InterruptedException ignored) {}
    }
}
package structural.decorator;

// Decorator pattern demo: message-processing pipeline where decorators add behavior
public interface MessageProcessor {
    String process(String message);
}
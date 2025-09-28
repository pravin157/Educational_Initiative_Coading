package structural.decorator;

// Logging decorator
public class LoggingDecorator extends ProcessorDecorator {
    public LoggingDecorator(MessageProcessor wrapped) { 
        super(wrapped); 
    }
    
    public String process(String message) {
        System.out.println("[Logging] input: " + message);
        String out = wrapped.process(message);
        System.out.println("[Logging] output: " + out);
        return out;
    }
}
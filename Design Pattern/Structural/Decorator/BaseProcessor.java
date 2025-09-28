package structural.decorator;

// Base component
public class BaseProcessor implements MessageProcessor {
    public String process(String message) { 
        return message; 
    }
}
package structural.decorator;

// Compression decorator (toy: remove vowels)
public class CompressionDecorator extends ProcessorDecorator {
    public CompressionDecorator(MessageProcessor wrapped) { 
        super(wrapped); 
    }
    
    public String process(String message) {
        String compressed = message.replaceAll("(?i)[aeiou]", "");
        return wrapped.process(compressed);
    }
}
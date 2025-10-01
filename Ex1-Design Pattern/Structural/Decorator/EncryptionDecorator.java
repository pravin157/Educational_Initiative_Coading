package structural.decorator;

// Encryption decorator (toy: simple ROT13 for letters)
public class EncryptionDecorator extends ProcessorDecorator {
    public EncryptionDecorator(MessageProcessor wrapped) { 
        super(wrapped); 
    }
    
    public String process(String message) {
        StringBuilder sb = new StringBuilder();
        for (char c : message.toCharArray()) {
            if (c >= 'a' && c <= 'z') sb.append((char)('a' + (c - 'a' + 13) % 26));
            else if (c >= 'A' && c <= 'Z') sb.append((char)('A' + (c - 'A' + 13) % 26));
            else sb.append(c);
        }
        return wrapped.process(sb.toString());
    }
}
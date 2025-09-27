package structural;

// Decorator pattern demo: message-processing pipeline where decorators add behavior

interface MessageProcessor {
    String process(String message);
}

// base component
class BaseProcessor implements MessageProcessor {
    public String process(String message) { return message; }
}

// abstract decorator
abstract class ProcessorDecorator implements MessageProcessor {
    protected final MessageProcessor wrapped;
    protected ProcessorDecorator(MessageProcessor wrapped) { this.wrapped = wrapped; }
}

// Logging decorator
class LoggingDecorator extends ProcessorDecorator {
    public LoggingDecorator(MessageProcessor wrapped) { super(wrapped); }
    public String process(String message) {
        System.out.println("[Logging] input: " + message);
        String out = wrapped.process(message);
        System.out.println("[Logging] output: " + out);
        return out;
    }
}

// Compression decorator (toy: remove vowels)
class CompressionDecorator extends ProcessorDecorator {
    public CompressionDecorator(MessageProcessor wrapped) { super(wrapped); }
    public String process(String message) {
        String compressed = message.replaceAll("(?i)[aeiou]", "");
        return wrapped.process(compressed);
    }
}

// Encryption decorator (toy: simple ROT13 for letters)
class EncryptionDecorator extends ProcessorDecorator {
    public EncryptionDecorator(MessageProcessor wrapped) { super(wrapped); }
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

public class DecoratorDemo {
    public static void run() {
        MessageProcessor processor = new BaseProcessor();

        // Build pipeline: Logging -> Encryption -> Compression -> Base
        processor = new LoggingDecorator(new EncryptionDecorator(new CompressionDecorator(processor)));

        String input = "Hello, Decorator Pattern!";
        String result = processor.process(input);

        System.out.println("Final processed message: " + result);
    }
}

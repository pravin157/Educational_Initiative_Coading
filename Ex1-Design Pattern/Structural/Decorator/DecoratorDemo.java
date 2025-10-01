package structural.decorator;

// Demo class for Decorator pattern
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
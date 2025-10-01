package structural.decorator;

// Abstract decorator
public abstract class ProcessorDecorator implements MessageProcessor {
    protected final MessageProcessor wrapped;
    
    protected ProcessorDecorator(MessageProcessor wrapped) { 
        this.wrapped = wrapped; 
    }
}
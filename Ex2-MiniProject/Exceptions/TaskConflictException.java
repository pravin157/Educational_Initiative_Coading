package exceptions;
// Custom exception for task conflicts
public class TaskConflictException extends RuntimeException {
    public TaskConflictException(String message) {
        super(message);
    }
}
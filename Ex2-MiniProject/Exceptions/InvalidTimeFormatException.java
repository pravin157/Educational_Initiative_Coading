package exceptions;
// Custom exception for invalid time format
public class InvalidTimeFormatException extends RuntimeException {
    public InvalidTimeFormatException(String message) {
        super(message);
    }
}
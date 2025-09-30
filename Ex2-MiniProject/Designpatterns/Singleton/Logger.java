package designpatterns.singleton;

import java.time.LocalDateTime;
// Singleton Logger class
public class Logger {
    private static Logger instance;
// Private constructor to prevent instantiation
    private Logger() {
    }

    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void logInfo(String message) {
        System.out.println("[INFO] " + LocalDateTime.now() + " - " + message);
    }
// Log error messages with exception details
    public void logError(String message, Exception e) {
        System.err.println("[ERROR] " + LocalDateTime.now() + " - " + message);
        if (e != null) {
            e.printStackTrace();
        }
    }

    public void logWarning(String message) {
        System.out.println("[WARNING] " + LocalDateTime.now() + " - " + message);
    }
}
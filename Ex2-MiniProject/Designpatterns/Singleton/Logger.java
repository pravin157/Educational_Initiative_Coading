package designpatterns.singleton;

import java.time.LocalDateTime;

public class Logger {
    private static Logger instance;

    private Logger() {
        // Private constructor to prevent instantiation
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

    public void logError(String message, Exception e) {
        System.err.println("[ERROR] " + LocalDateTime.now() + " - " + message);
        if (e != null) {
            e.printStackTrace();
        }
    }

    public void logWarning(String message) {
        System.out.println("[WARNING] " + LocalDateTime.now() + " - " + message);
    }

    public void logDebug(String message) {
        System.out.println("[DEBUG] " + LocalDateTime.now() + " - " + message);
    }
}
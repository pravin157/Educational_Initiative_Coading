package designpatterns.factory;

import designpatterns.singleton.Logger;
import models.Task;
import models.Priority;
import exceptions.InvalidTimeFormatException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
// Factory class for creating Task instances with validation and logging
public class TaskFactory {
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm");
    private static Logger logger = Logger.getInstance();

    public static Task createTask(String description, String startTimeStr, String endTimeStr, String priorityStr) {
        try {
            logger.logInfo("Creating task: " + description);
            
           
            LocalTime startTime = parseTime(startTimeStr);
            LocalTime endTime = parseTime(endTimeStr);
            
            if (!endTime.isAfter(startTime)) {
                throw new InvalidTimeFormatException("End time must be after start time");
            }
            
            Priority priority = Priority.fromString(priorityStr);
            
            return new Task(description, startTime, endTime, priority);
            
        } catch (DateTimeParseException e) {
            String errorMsg = "Invalid time format. Please use HH:mm format (00:00 - 23:59)";
            logger.logError(errorMsg, e);
            throw new InvalidTimeFormatException(errorMsg);
        } catch (IllegalArgumentException e) {
            String errorMsg = "Invalid priority. Available options: High, Medium, Low";
            logger.logError(errorMsg, e);
            throw new IllegalArgumentException(errorMsg);
        }
    }

    private static LocalTime parseTime(String timeStr) {
        try {
            return LocalTime.parse(timeStr, TIME_FORMATTER);
        } catch (DateTimeParseException e) {
            throw new InvalidTimeFormatException("Invalid time format: " + timeStr + ". Use HH:mm format.");
        }
    }


    public static Task createTask(String description, LocalTime startTime, LocalTime endTime, Priority priority) {
        logger.logInfo("Creating task with direct parameters: " + description);
        return new Task(description, startTime, endTime, priority);
    }
}
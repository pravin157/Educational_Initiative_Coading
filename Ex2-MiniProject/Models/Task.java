package models;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Task {
    private String description;
    private LocalTime startTime;
    private LocalTime endTime;
    private Priority priority;
    private boolean completed;

    public Task(String description, LocalTime startTime, LocalTime endTime, Priority priority) {
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
        this.priority = priority;
        this.completed = false;
    }

    // Getters and Setters
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public LocalTime getStartTime() { return startTime; }
    public void setStartTime(LocalTime startTime) { this.startTime = startTime; }

    public LocalTime getEndTime() { return endTime; }
    public void setEndTime(LocalTime endTime) { this.endTime = endTime; }

    public Priority getPriority() { return priority; }
    public void setPriority(Priority priority) { this.priority = priority; }

    public boolean isCompleted() { return completed; }
    public void setCompleted(boolean completed) { this.completed = completed; }

    public boolean conflictsWith(Task other) {
        return !(endTime.isBefore(other.startTime) || startTime.isAfter(other.endTime));
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        String status = completed ? "[COMPLETED] " : "";
        return String.format("%s - %s: %s%s [%s]", 
            startTime.format(formatter), 
            endTime.format(formatter), 
            status, 
            description, 
            priority.getDisplayName());
    }
}
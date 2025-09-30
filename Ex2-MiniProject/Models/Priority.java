package models;
// Enum for task priority
public enum Priority {
    HIGH("High"),
    MEDIUM("Medium"),
    LOW("Low");
// Display name for each priority level
    private final String displayName;

    Priority(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
// Method to get Priority from string
    public static Priority fromString(String text) {
        for (Priority priority : Priority.values()) {
            if (priority.displayName.equalsIgnoreCase(text)) {
                return priority;
            }
        }
        throw new IllegalArgumentException("Invalid priority: " + text);
    }
}
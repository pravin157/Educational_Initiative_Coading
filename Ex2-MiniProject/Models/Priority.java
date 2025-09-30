package models;

public enum Priority {
    HIGH("High"),
    MEDIUM("Medium"),
    LOW("Low");

    private final String displayName;

    Priority(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static Priority fromString(String text) {
        for (Priority priority : Priority.values()) {
            if (priority.displayName.equalsIgnoreCase(text)) {
                return priority;
            }
        }
        throw new IllegalArgumentException("Invalid priority: " + text);
    }
}
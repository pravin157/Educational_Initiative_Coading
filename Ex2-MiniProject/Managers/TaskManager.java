package managers;

import designpatterns.singleton.ScheduleManager;
import designpatterns.factory.TaskFactory;
import models.Task;
import models.Priority;
import exceptions.TaskConflictException;
import exceptions.TaskNotFoundException;
import exceptions.InvalidTimeFormatException;
import java.util.List;

public class TaskManager {
    private ScheduleManager scheduleManager;

    public TaskManager() {
        this.scheduleManager = ScheduleManager.getInstance();
    }

    // Public API methods
    public void addTask(String description, String startTime, String endTime, String priority) {
        try {
            Task task = TaskFactory.createTask(description, startTime, endTime, priority);
            scheduleManager.addTask(task);
            System.out.println("✓ Task added successfully. No conflicts.");
        } catch (TaskConflictException e) {
            System.out.println("✗ Error: " + e.getMessage());
            throw e;
        } catch (InvalidTimeFormatException | IllegalArgumentException e) {
            System.out.println("✗ Error: " + e.getMessage());
            throw e;
        }
    }

    public void removeTask(String description) {
        try {
            scheduleManager.removeTask(description);
            System.out.println("✓ Task removed successfully.");
        } catch (TaskNotFoundException e) {
            System.out.println("✗ Error: " + e.getMessage());
            throw e;
        }
    }

    public void editTask(String oldDescription, String newDescription, String startTime, String endTime, String priority) {
        try {
            Task updatedTask = TaskFactory.createTask(newDescription, startTime, endTime, priority);
            scheduleManager.editTask(oldDescription, updatedTask);
            System.out.println("✓ Task updated successfully.");
        } catch (Exception e) {
            System.out.println("✗ Error: " + e.getMessage());
            throw e;
        }
    }

    public void markTaskCompleted(String description) {
        try {
            scheduleManager.markTaskAsCompleted(description);
            System.out.println("✓ Task marked as completed.");
        } catch (TaskNotFoundException e) {
            System.out.println("✗ Error: " + e.getMessage());
            throw e;
        }
    }

    public void viewAllTasks() {
        List<Task> tasks = scheduleManager.getAllTasks();
        if (tasks.isEmpty()) {
            System.out.println("📝 No tasks scheduled for the day.");
        } else {
            System.out.println("\n📋 DAILY SCHEDULE (" + tasks.size() + " tasks):");
            System.out.println("=========================================");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
            System.out.println("=========================================");
        }
    }

    public void viewTasksByPriority(String priorityStr) {
        try {
            Priority priority = Priority.fromString(priorityStr);
            List<Task> tasks = scheduleManager.getTasksByPriority(priority);
            
            if (tasks.isEmpty()) {
                System.out.println("📝 No tasks with " + priorityStr + " priority.");
            } else {
                System.out.println("\n🎯 " + priorityStr.toUpperCase() + " PRIORITY TASKS (" + tasks.size() + "):");
                System.out.println("=========================================");
                for (int i = 0; i < tasks.size(); i++) {
                    System.out.println((i + 1) + ". " + tasks.get(i));
                }
                System.out.println("=========================================");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("✗ Error: " + e.getMessage());
        }
    }

    public void viewCompletedTasks() {
        List<Task> tasks = scheduleManager.getCompletedTasks();
        if (tasks.isEmpty()) {
            System.out.println("✅ No completed tasks.");
        } else {
            System.out.println("\n✅ COMPLETED TASKS (" + tasks.size() + "):");
            System.out.println("=========================================");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
            System.out.println("=========================================");
        }
    }

    public void viewPendingTasks() {
        List<Task> tasks = scheduleManager.getPendingTasks();
        if (tasks.isEmpty()) {
            System.out.println("📝 No pending tasks.");
        } else {
            System.out.println("\n⏳ PENDING TASKS (" + tasks.size() + "):");
            System.out.println("=========================================");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
            System.out.println("=========================================");
        }
    }

    public int getTaskCount() {
        return scheduleManager.getTaskCount();
    }
}
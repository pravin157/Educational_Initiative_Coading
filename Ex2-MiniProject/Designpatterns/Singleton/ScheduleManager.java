package designpatterns.singleton;

import designpatterns.observer.TaskListener;
import designpatterns.observer.TaskConflictNotifier;
import models.Task;
import models.Priority;
import exceptions.TaskConflictException;
import exceptions.TaskNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class ScheduleManager implements TaskListener {
    private static ScheduleManager instance;
    private List<Task> tasks;
    private Logger logger;
    private TaskConflictNotifier conflictNotifier;

    private ScheduleManager() {
        tasks = new ArrayList<>();
        logger = Logger.getInstance();
        conflictNotifier = new TaskConflictNotifier();
        conflictNotifier.addListener(this);
        logger.logInfo("ScheduleManager initialized");
    }

    public static synchronized ScheduleManager getInstance() {
        if (instance == null) {
            instance = new ScheduleManager();
        }
        return instance;
    }

    // Task operations
    public void addTask(Task newTask) {
        try {
            // Check for conflicts
            for (Task existingTask : tasks) {
                if (newTask.conflictsWith(existingTask)) {
                    String errorMsg = String.format("Task conflicts with existing task '%s'", existingTask.getDescription());
                    conflictNotifier.notifyTaskConflict(newTask, existingTask);
                    throw new TaskConflictException(errorMsg);
                }
            }
            
            tasks.add(newTask);
            sortTasksByStartTime();
            conflictNotifier.notifyTaskAdded(newTask);
            logger.logInfo("Task added successfully: " + newTask.getDescription());
            
        } catch (Exception e) {
            logger.logError("Failed to add task: " + newTask.getDescription(), e);
            throw e;
        }
    }

    public void removeTask(String description) {
        try {
            Task taskToRemove = findTaskByDescription(description);
            tasks.remove(taskToRemove);
            conflictNotifier.notifyTaskRemoved(taskToRemove);
            logger.logInfo("Task removed successfully: " + description);
            
        } catch (TaskNotFoundException e) {
            logger.logError("Failed to remove task: " + description, e);
            throw e;
        }
    }

    public void editTask(String oldDescription, Task updatedTask) {
        try {
            Task oldTask = findTaskByDescription(oldDescription);
            
            // Check for conflicts excluding the current task
            for (Task existingTask : tasks) {
                if (!existingTask.getDescription().equals(oldDescription) && 
                    updatedTask.conflictsWith(existingTask)) {
                    String errorMsg = String.format("Updated task conflicts with existing task '%s'", 
                        existingTask.getDescription());
                    throw new TaskConflictException(errorMsg);
                }
            }
            
            tasks.remove(oldTask);
            tasks.add(updatedTask);
            sortTasksByStartTime();
            conflictNotifier.notifyTaskUpdated(oldTask, updatedTask);
            logger.logInfo("Task updated successfully: " + oldDescription + " -> " + updatedTask.getDescription());
            
        } catch (Exception e) {
            logger.logError("Failed to edit task: " + oldDescription, e);
            throw e;
        }
    }

    public void markTaskAsCompleted(String description) {
        try {
            Task task = findTaskByDescription(description);
            task.setCompleted(true);
            conflictNotifier.notifyTaskUpdated(task, task);
            logger.logInfo("Task marked as completed: " + description);
            
        } catch (TaskNotFoundException e) {
            logger.logError("Failed to mark task as completed: " + description, e);
            throw e;
        }
    }

    // View operations
    public List<Task> getAllTasks() {
        return new ArrayList<>(tasks);
    }

    public List<Task> getTasksByPriority(Priority priority) {
        return tasks.stream()
                .filter(task -> task.getPriority() == priority)
                .collect(Collectors.toList());
    }

    public List<Task> getCompletedTasks() {
        return tasks.stream()
                .filter(Task::isCompleted)
                .collect(Collectors.toList());
    }

    public List<Task> getPendingTasks() {
        return tasks.stream()
                .filter(task -> !task.isCompleted())
                .collect(Collectors.toList());
    }

    // Helper methods
    private Task findTaskByDescription(String description) {
        return tasks.stream()
                .filter(task -> task.getDescription().equalsIgnoreCase(description))
                .findFirst()
                .orElseThrow(() -> new TaskNotFoundException("Task not found: " + description));
    }

    private void sortTasksByStartTime() {
        tasks.sort(Comparator.comparing(Task::getStartTime));
    }

    // Observer pattern implementation
    @Override
    public void onTaskConflict(Task newTask, Task existingTask) {
        logger.logWarning(String.format("Task conflict detected: '%s' conflicts with '%s'", 
            newTask.getDescription(), existingTask.getDescription()));
        System.out.println("ALERT: Task conflict! '" + newTask.getDescription() + 
                         "' conflicts with '" + existingTask.getDescription() + "'");
    }

    @Override
    public void onTaskAdded(Task task) {
        logger.logInfo("Observer: Task added - " + task.getDescription());
    }

    @Override
    public void onTaskRemoved(Task task) {
        logger.logInfo("Observer: Task removed - " + task.getDescription());
    }

    @Override
    public void onTaskUpdated(Task oldTask, Task newTask) {
        logger.logInfo("Observer: Task updated - " + oldTask.getDescription() + " to " + newTask.getDescription());
    }

    public boolean hasTasks() {
        return !tasks.isEmpty();
    }

    public int getTaskCount() {
        return tasks.size();
    }
}
package designpatterns.observer;

import models.Task;
// Listener interface for task events
public interface TaskListener {
    void onTaskConflict(Task newTask, Task existingTask);
    void onTaskAdded(Task task);
    void onTaskRemoved(Task task);
    void onTaskUpdated(Task oldTask, Task newTask);
}
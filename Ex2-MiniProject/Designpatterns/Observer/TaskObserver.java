package designpatterns.observer;

import models.Task;
import java.util.ArrayList;
import java.util.List;
// Observer class to manage and notify task listeners
public class TaskObserver {
    private List<TaskListener> listeners = new ArrayList<>();
// Add a listener to the observer
    public void addListener(TaskListener listener) {
        listeners.add(listener);
    }

    public void removeListener(TaskListener listener) {
        listeners.remove(listener);
    }

    public void notifyTaskConflict(Task newTask, Task existingTask) {
        for (TaskListener listener : listeners) {
            listener.onTaskConflict(newTask, existingTask);
        }
    }

    public void notifyTaskAdded(Task task) {
        for (TaskListener listener : listeners) {
            listener.onTaskAdded(task);
        }
    }

    public void notifyTaskRemoved(Task task) {
        for (TaskListener listener : listeners) {
            listener.onTaskRemoved(task);
        }
    }

    public void notifyTaskUpdated(Task oldTask, Task newTask) {
        for (TaskListener listener : listeners) {
            listener.onTaskUpdated(oldTask, newTask);
        }
    }
}
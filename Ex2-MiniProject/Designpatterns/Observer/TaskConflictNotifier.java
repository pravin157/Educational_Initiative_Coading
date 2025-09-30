package designpatterns.observer;

import designpatterns.singleton.Logger;
import models.Task;
// Observer class to notify listeners about task conflicts and changes
public class TaskConflictNotifier extends TaskObserver {
    private Logger logger;
// Constructor initializing the logger
    public TaskConflictNotifier() {
        this.logger = Logger.getInstance();
    }

    @Override
    public void notifyTaskConflict(Task newTask, Task existingTask) {
        logger.logWarning("Notifying listeners about task conflict between: " + 
                         newTask.getDescription() + " and " + existingTask.getDescription());
        super.notifyTaskConflict(newTask, existingTask);
    }

    @Override
    public void notifyTaskAdded(Task task) {
        logger.logInfo("Notifying listeners about task addition: " + task.getDescription());
        super.notifyTaskAdded(task);
    }

    @Override
    public void notifyTaskRemoved(Task task) {
        logger.logInfo("Notifying listeners about task removal: " + task.getDescription());
        super.notifyTaskRemoved(task);
    }

    @Override
    public void notifyTaskUpdated(Task oldTask, Task newTask) {
        logger.logInfo("Notifying listeners about task update: " + oldTask.getDescription());
        super.notifyTaskUpdated(oldTask, newTask);
    }
}
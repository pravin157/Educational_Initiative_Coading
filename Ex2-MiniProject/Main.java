import managers.TaskManager;
import java.util.Scanner;
// Main class to run the Astronaut Daily Schedule Organizer application
public class Main {
    private static TaskManager taskManager;
    private static Scanner scanner;

    public static void main(String[] args) {
        initializeApplication();
        displayWelcomeMessage();
        runApplication();
    }

    private static void initializeApplication() {
        taskManager = new TaskManager();
        scanner = new Scanner(System.in);
    }

    private static void displayWelcomeMessage() {
        System.out.println("=========================================");
        System.out.println("   ASTRONAUT DAILY SCHEDULE ORGANIZER");
        System.out.println("=========================================");
        // System.out.println("    Design Patterns Implementation:");
        // System.out.println("    • Singleton Pattern  ✓");
        // System.out.println("    • Factory Pattern    ✓");
        // System.out.println("    • Observer Pattern   ✓");
        // System.out.println("=========================================");
        // System.out.println();
    }

    private static void runApplication() {
        boolean running = true;

        while (running) {
            displayMenu();
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    addTask();
                    break;
                case "2":
                    removeTask();
                    break;
                case "3":
                    editTask();
                    break;
                case "4":
                    markTaskCompleted();
                    break;
                case "5":
                    taskManager.viewAllTasks();
                    break;
                case "6":
                    viewTasksByPriority();
                    break;
                case "7":
                    taskManager.viewCompletedTasks();
                    break;
                case "8":
                    taskManager.viewPendingTasks();
                    break;
                case "9":
                    showStatistics();
                    break;
                case "0":
                    running = false;
                    System.out.println("Thank you for using Astronaut Schedule Organizer!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            if (running) {
                System.out.println("\nPress Enter to continue...");
                scanner.nextLine();
            }
        }

        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\n=== MAIN MENU ===");
        System.out.println("1. Add Task");
        System.out.println("2. Remove Task");
        System.out.println("3. Edit Task");
        System.out.println("4. Mark Task as Completed");
        System.out.println("5. View All Tasks");
        System.out.println("6. View Tasks by Priority");
        System.out.println("7. View Completed Tasks");
        System.out.println("8. View Pending Tasks");
        System.out.println("9. Statistics");
        System.out.println("0. Exit");
        System.out.print("Enter your choice (0-9): ");
    }

    private static void addTask() {
        System.out.println("\n=== ADD NEW TASK ===");
        
        System.out.print("Enter task description: ");
        String description = scanner.nextLine().trim();
        
        System.out.print("Enter start time (HH:mm): ");
        String startTime = scanner.nextLine().trim();
        
        System.out.print("Enter end time (HH:mm): ");
        String endTime = scanner.nextLine().trim();
        
        System.out.print("Enter priority (High/Medium/Low): ");
        String priority = scanner.nextLine().trim();
        
        taskManager.addTask(description, startTime, endTime, priority);
    }

    private static void removeTask() {
        System.out.println("\n=== REMOVE TASK ===");
        System.out.print("Enter task description to remove: ");
        String description = scanner.nextLine().trim();
        taskManager.removeTask(description);
    }

    private static void editTask() {
        System.out.println("\n=== EDIT TASK ===");
        System.out.print("Enter current task description: ");
        String oldDescription = scanner.nextLine().trim();
        
        System.out.print("Enter new task description: ");
        String newDescription = scanner.nextLine().trim();
        
        System.out.print("Enter new start time (HH:mm): ");
        String startTime = scanner.nextLine().trim();
        
        System.out.print("Enter new end time (HH:mm): ");
        String endTime = scanner.nextLine().trim();
        
        System.out.print("Enter new priority (High/Medium/Low): ");
        String priority = scanner.nextLine().trim();
        
        taskManager.editTask(oldDescription, newDescription, startTime, endTime, priority);
    }

    private static void markTaskCompleted() {
        System.out.println("\n=== MARK TASK AS COMPLETED ===");
        System.out.print("Enter task description: ");
        String description = scanner.nextLine().trim();
        taskManager.markTaskCompleted(description);
    }

    private static void viewTasksByPriority() {
        System.out.println("\n=== VIEW TASKS BY PRIORITY ===");
        System.out.print("Enter priority (High/Medium/Low): ");
        String priority = scanner.nextLine().trim();
        taskManager.viewTasksByPriority(priority);
    }

    private static void showStatistics() {
        System.out.println("\n=== STATISTICS ===");
        System.out.println("Total Tasks: " + taskManager.getTaskCount());
        // Additional statistics can be added here
    }
}
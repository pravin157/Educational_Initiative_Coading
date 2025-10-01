# Ex1 - Design Patterns (Java)

This exercise demonstrates multiple classic design patterns implemented in Java. It is organized into Behavioral, Creational, and Structural categories. The `Main.java` entry point runs small demos for each pattern.

## Repository Structure
```
Ex1-Design Pattern/
├── Main.java
├── Behavioral/
│   ├── Observer/
│   │   ├── CurrentConditionsDisplay.java
│   │   ├── Display.java
│   │   ├── ObserverDemo.java
│   │   ├── StatisticsDisplay.java
│   │   └── WeatherStation.java
│   └── Strategy/
│       ├── CreditCardPayment.java
│       ├── PaymentDetails.java
│       ├── PaymentStrategy.java
│       ├── PayPalPayment.java
│       ├── ShoppingCart.java
│       └── StrategyDemo.java
├── Creational/
│   ├── Factory/
│   │   ├── EmailNotifier.java
│   │   ├── FactoryDemo.java
│   │   ├── Notifier.java
│   │   ├── NotifierFactory.java
│   │   ├── NotifierType.java
│   │   ├── PushNotifier.java
│   │   └── SMSNotifier.java
│   └── Singleton/
│       ├── MessageBroker.java
│       └── SingletonDemo.java
└── Structural/
    ├── Adapter/
    │   ├── AdapterDemo.java
    │   ├── CreditCardProcessor.java
    │   ├── PaymentProcessor.java
    │   ├── PayPalAdapter.java
    │   └── PayPalService.java
    └── Decorator/
        ├── BaseProcessor.java
        ├── CompressionDecorator.java
        ├── DecoratorDemo.java
        ├── EncryptionDecorator.java
        ├── LoggingDecorator.java
        ├── MessageProcessor.java
        └── ProcessorDecorator.java
```

## Patterns Demonstrated

- Behavioral: Strategy, Observer
- Creational: Factory, Singleton
- Structural: Adapter, Decorator

Each demo class under the pattern folders contains a `run()` method that prints demonstration output.

## How to Compile

From the `Ex1-Design Pattern` directory:

PowerShell (recommended):

```powershell
# compile all Java files together so inter-class dependencies are resolved
javac -cp . $(Get-ChildItem -Recurse -Filter "*.java" | ForEach-Object { $_.FullName })
```
## How to Run
From the `Ex1-Design Pattern` directory after compiling:

```cmd
java Main
```

# Ex2 - Mini Project: Astronaut Daily Schedule Organizer (Java)

This mini-project is a console-based Astronaut Daily Schedule Organizer implemented in Java. It demonstrates practical usage of design patterns (Singleton, Factory, Observer) and contains simple task management features.

## Project Structure 

```
Ex2-MiniProject/
├── Main.java                         # Console UI and application flow
├── Designpatterns/
│   ├── Factory/                      # TaskFactory (creates different Task types)
│   │   └── TaskFactory.java
│   ├── Observer/                     # Observer pattern for task conflict notifications
│   │   ├── TaskConflictNotifier.java
│   │   ├── TaskListener.java
│   │   └── TaskObserver.java
│   └── Singleton/                    # Logger and ScheduleManager singletons
│       ├── Logger.java
│       └── ScheduleManager.java
├── Exceptions/                        # Custom exception classes (if any)
├── Managers/                          # Business logic and task management
│   └── TaskManager.java
└── Models/                            # Domain models (Task, Priority, etc.)
    └── (task model files)
```

## Quick Features 

- Add, remove, and edit tasks (description, start/end time, priority).
- Mark tasks as completed.
- View all, completed, or pending tasks.
- View tasks filtered by priority.
- Simple statistics (total tasks count).
- Notifications for scheduling conflicts using Observer pattern.
- Centralized logging and schedule management via Singleton pattern.
- Task creation via Factory pattern.

## How to Compile & Run

From the repository root or the `Ex2-MiniProject` directory (Windows):

PowerShell (recommended):

```powershell
# Navigate to the project folder if needed
Set-Location -Path "Ex2-MiniProject"

# Compile all Java files together so inter-class dependencies are resolved
javac -d . models/*.java exceptions/*.java designpatterns/singleton/*.java designpatterns/factory/*.java designpatterns/observer/*.java managers/*.java Main.java

# Run the application
java Main
```


### Example interactive session
```
=========================================
   ASTRONAUT DAILY SCHEDULE ORGANIZER
=========================================

=== MAIN MENU ===
1. Add Task
2. Remove Task
3. Edit Task
4. Mark Task as Completed
5. View All Tasks
6. View Tasks by Priority
7. View Completed Tasks
8. View Pending Tasks
9. Statistics
0. Exit
Enter your choice (0-9): 1

=== ADD NEW TASK ===
Enter task description: Oxygen system check
Enter start time (HH:mm): 09:00
Enter end time (HH:mm): 09:30
Enter priority (High/Medium/Low): High

Task added successfully.
```


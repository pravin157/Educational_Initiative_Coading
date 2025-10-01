# Design Patterns Implementation in Java

This project demonstrates the implementation of various design patterns in Java, organized into three main categories: Behavioral, Creational, and Structural patterns.

## Project Structure

```
Design Pattern/
├── Main.java                           # Entry point demonstrating all patterns
├── Behavioral/
│   ├── Observer/                       # Observer Pattern Implementation
│   │   ├── Display.java               # Observer interface
│   │   ├── WeatherStation.java        # Subject (Observable)
│   │   ├── CurrentConditionsDisplay.java
│   │   ├── StatisticsDisplay.java
│   │   └── ObserverDemo.java          # Demo class
│   └── Strategy/                       # Strategy Pattern Implementation
│       ├── PaymentStrategy.java       # Strategy interface
│       ├── PaymentDetails.java        # Payment data class
│       ├── CreditCardPayment.java     # Concrete strategy
│       ├── PayPalPayment.java         # Concrete strategy
│       ├── ShoppingCart.java          # Context class
│       └── StrategyDemo.java          # Demo class
├── Creational/
│   ├── Factory/                        # Factory Pattern Implementation
│   │   ├── Notifier.java              # Product interface
│   │   ├── NotifierType.java          # Enum for notifier types
│   │   ├── EmailNotifier.java         # Concrete product
│   │   ├── SMSNotifier.java           # Concrete product
│   │   ├── PushNotifier.java          # Concrete product
│   │   ├── NotifierFactory.java       # Factory class
│   │   └── FactoryDemo.java           # Demo class
│   └── Singleton/                      # Singleton Pattern Implementation
│       ├── MessageBroker.java         # Singleton class
│       └── SingletonDemo.java         # Demo class
└── Structural/
    ├── Adapter/                        # Adapter Pattern Implementation
    │   ├── PaymentProcessor.java      # Target interface
    │   ├── CreditCardProcessor.java   # Adaptee
    │   ├── PayPalService.java         # Third-party service
    │   ├── PayPalAdapter.java         # Adapter class
    │   └── AdapterDemo.java           # Demo class
    └── Decorator/                      # Decorator Pattern Implementation
        ├── MessageProcessor.java      # Component interface
        ├── BaseProcessor.java         # Concrete component
        ├── ProcessorDecorator.java    # Base decorator
        ├── LoggingDecorator.java      # Concrete decorator
        ├── EncryptionDecorator.java   # Concrete decorator
        ├── CompressionDecorator.java  # Concrete decorator
        └── DecoratorDemo.java         # Demo class
```

## Design Patterns Implemented

### Behavioral Patterns

#### 1. Observer Pattern
**Purpose**: Defines a one-to-many dependency between objects so that when one object changes state, all its dependents are notified automatically.

**Implementation**: Weather monitoring system where weather station notifies multiple display devices.

#### 2. Strategy Pattern
**Purpose**: Defines a family of algorithms, encapsulates each one, and makes them interchangeable.

**Implementation**: Payment processing system with different payment methods (Credit Card, PayPal).

### Creational Patterns

#### 3. Singleton Pattern
**Purpose**: Ensures a class has only one instance and provides global access to it.

**Implementation**: Message broker service that manages notification dispatch.

#### 4. Factory Pattern
**Purpose**: Creates objects without specifying their concrete classes.

**Implementation**: Notification system factory that creates different types of notifiers (Email, SMS, Push).

### Structural Patterns

#### 5. Adapter Pattern
**Purpose**: Allows incompatible interfaces to work together by wrapping an existing class with a new interface.

**Implementation**: Payment processing system that adapts third-party PayPal service to work with existing payment interface.

#### 6. Decorator Pattern
**Purpose**: Dynamically adds new functionality to objects without altering their structure.

**Implementation**: Message processing system with configurable features like logging, encryption, and compression.

## How to Compile and Run

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Command line access (PowerShell, Command Prompt, or Terminal)

### Compilation

#### Using PowerShell (Recommended):
```powershell
# Navigate to the Design Pattern directory
cd "Design Pattern"

# Compile all Java files together
javac -cp . $(Get-ChildItem -Recurse -Filter "*.java" | ForEach-Object { $_.FullName })
```

#### Using Command Prompt:
```cmd
cd "Design Pattern"
for /r . %i in (*.java) do javac -cp . "%i"
```

### Running the Application

```bash
java Main
```

## Expected Output

The application will demonstrate each design pattern with sample output:

```
--- Strategy Pattern ---
[Payment processing demonstrations]

--- Observer Pattern ---
[Weather station notifications]

--- Singleton Pattern ---
[Message broker operations]

--- Factory Pattern ---
[Different notifier creations]

--- Adapter Pattern ---
[Payment adapter demonstrations]

--- Decorator Pattern ---
[Message processing with various decorators]
```

## Learning Objectives

This project helps understand:

1. **Separation of Concerns**: Each pattern addresses specific design challenges
2. **Code Reusability**: Patterns promote reusable and maintainable code
3. **Flexibility**: Patterns make code more flexible and easier to extend
4. **Best Practices**: Industry-standard approaches to common programming problems

## Design Pattern Benefits

- **Observer**: Loose coupling between subjects and observers
- **Strategy**: Easy to add new algorithms without modifying existing code
- **Singleton**: Controlled access to shared resources
- **Factory**: Centralized object creation logic
- **Adapter**: Integration of incompatible interfaces
- **Decorator**: Dynamic behavior modification without inheritance

## Contributing

Feel free to extend this project by:
- Adding more design patterns
- Improving existing implementations
- Adding unit tests
- Enhancing documentation

## Author

Educational Initiative Coding Project
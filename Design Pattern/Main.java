import behavioral.*;
// import creational.*;
import structural.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Strategy Pattern ---");
        StrategyDemo.run();

        System.out.println("\n--- Observer Pattern ---");
        ObserverDemo.run();

        // System.out.println("\n--- Singleton Pattern ---");
        // SingletonDemo.run();

        // System.out.println("\n--- Factory Pattern ---");
        // FactoryDemo.run();

        System.out.println("\n--- Adapter Pattern ---");
        AdapterDemo.run();

        System.out.println("\n--- Decorator Pattern ---");
        DecoratorDemo.run(); 


    }
}

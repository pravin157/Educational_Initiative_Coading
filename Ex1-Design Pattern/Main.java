import behavioral.strategy.StrategyDemo;
import behavioral.observer.ObserverDemo;
import creational.singleton.SingletonDemo;
import creational.factory.FactoryDemo;
import structural.adapter.AdapterDemo;
import structural.decorator.DecoratorDemo;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Strategy Pattern ---");
        StrategyDemo.run();

        System.out.println("\n--- Observer Pattern ---");
        ObserverDemo.run();

        System.out.println("\n--- Singleton Pattern ---");
        SingletonDemo.run();

        System.out.println("\n--- Factory Pattern ---");
        FactoryDemo.run();

        System.out.println("\n--- Adapter Pattern ---");
        AdapterDemo.run();

        System.out.println("\n--- Decorator Pattern ---");
        DecoratorDemo.run(); 

    }
}
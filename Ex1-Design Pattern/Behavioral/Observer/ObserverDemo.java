package behavioral.observer;

// Demo class for Observer pattern
public class ObserverDemo {
    public static void run() {
        WeatherStation station = new WeatherStation();

        CurrentConditionsDisplay lcd = new CurrentConditionsDisplay("LCD-1");
        StatisticsDisplay stats = new StatisticsDisplay();

        station.register(lcd);
        station.register(stats);

        station.measurementsChanged(22.5f, 65.0f);
        station.measurementsChanged(23.0f, 63.5f);

        station.unregister(lcd);
        station.measurementsChanged(21.0f, 70.0f);
    }
}
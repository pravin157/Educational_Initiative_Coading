package behavioral;

import java.util.*;

// Observer
interface Display {
    void update(float temperature, float humidity);
}
// Concrete Observer
class CurrentConditionsDisplay implements Display {
    private float temperature;
    private float humidity;
    private final String id;

    public CurrentConditionsDisplay(String id) { this.id = id; }

    public void update(float temperature, float humidity) {
        this.temperature = temperature;
        this.humidity = humidity;
        System.out.printf("Current conditions: %.1f°C and %.1f%% humidity\n", temperature, humidity);
    }
} 
// Concrete Observer
class StatisticsDisplay implements Display {
    private int count = 0;
    private float sum = 0f;
    private float min = Float.MAX_VALUE;
    private float max = Float.MIN_VALUE;

    public void update(float temperature, float humidity) {
        count++;
        sum += temperature;

        if (temperature < min) min = temperature;
        if (temperature > max) max = temperature;

        float avg = sum / count;

        System.out.printf("Statistics Temp: %.1f°C | Avg: %.1f°C | Min: %.1f°C | Max: %.1f°C | Samples: %d\n",
                          temperature, avg, min, max, count);
    }
}

// Observable   
class WeatherStation {
    private final Set<Display> observers = new LinkedHashSet<>();

    public void register(Display d) { observers.add(d); }
    public void unregister(Display d) { observers.remove(d); }

    public void measurementsChanged(float temperature, float humidity) {
      
        List<Display> snapshot = new ArrayList<>(observers);
        for (Display d : snapshot) d.update(temperature, humidity);
    }
}
// Demo
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
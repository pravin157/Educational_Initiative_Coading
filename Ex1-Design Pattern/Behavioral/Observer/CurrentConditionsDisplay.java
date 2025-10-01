package behavioral.observer;

// Concrete Observer
public class CurrentConditionsDisplay implements Display {
    private float temperature;
    private float humidity;
    private final String id;

    public CurrentConditionsDisplay(String id) { 
        this.id = id; 
    }

    public void update(float temperature, float humidity) {
        this.temperature = temperature;
        this.humidity = humidity;
        System.out.printf("Current conditions: %.1f°C and %.1f%% humidity\n", temperature, humidity);
    }
}
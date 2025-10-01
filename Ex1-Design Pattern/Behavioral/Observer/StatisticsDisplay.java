package behavioral.observer;

// Concrete Observer
public class StatisticsDisplay implements Display {
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
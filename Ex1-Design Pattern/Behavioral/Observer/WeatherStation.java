package behavioral.observer;

import java.util.*;

// Observable Weather Station
public class WeatherStation {
    private final Set<Display> observers = new LinkedHashSet<>();

    public void register(Display d) { 
        observers.add(d); 
    }
    
    public void unregister(Display d) { 
        observers.remove(d); 
    }

    public void measurementsChanged(float temperature, float humidity) {
        List<Display> snapshot = new ArrayList<>(observers);
        for (Display d : snapshot) {
            d.update(temperature, humidity);
        }
    }
}
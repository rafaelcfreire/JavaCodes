package br.com.ehnois.chp4.vehicle.tracker.immutable;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

final class DelegatingVehicleTracker {
    private final ConcurrentMap<String, Point> locations;
    private final Map<String, Point> unmodifiableMap;

    public DelegatingVehicleTracker(Map<String, Point> points) {
        locations = new ConcurrentHashMap<>(points);
        unmodifiableMap = Collections.unmodifiableMap(locations);
    }

    public Map<String, Point> getLocations() {
        return unmodifiableMap;
//        return Collections.unmodifiableMap(new HashMap<>(locations));
    }

    public Point getLocation(String id) {
        return locations.get(id);
    }

    public void setLocation(String id, int x, int y) {
        if (locations.replace(id, new Point(x, y)) == null)
            throw new IllegalArgumentException("invalid vehicle name: "+id);
    }

    public static void main(String[] args) {
        Map<String, Point> car1 = new HashMap<>();
        car1.put("bmw", new Point(0, 5));
        DelegatingVehicleTracker d1 = new DelegatingVehicleTracker(car1);

        new Thread(() -> {
            Map<String, Point> live = d1.getLocations();
            try {
                live.values().forEach((t) -> System.out.println("X: "+t.x+" Y: "+t.y));
                Thread.sleep(5000);
                System.out.println("After sleeping");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            live.values().forEach((t) -> System.out.println("X: "+t.x+" Y: "+t.y));
        }).start();
        new Thread(() -> {
            System.out.println("updating d1 ");
            d1.setLocation("bmw", 1, 15);
        }).start();
    }
}

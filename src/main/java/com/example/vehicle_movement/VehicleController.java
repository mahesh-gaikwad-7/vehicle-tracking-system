package com.example.vehicle_movement;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
public class VehicleController {

    private final double[] latitudes = {17.385044, 17.385045, 17.385046}; // Example latitudes
    private final double[] longitudes = {78.486671, 78.486672, 78.486673}; // Example longitudes
    private int currentIndex = 0;

    @GetMapping("/api/vehicle/location")
    public Map<String, Double> getVehicleLocation() {
        if (currentIndex >= latitudes.length) {
            currentIndex = 0; // Loop back to the start
        }
        Map<String, Double> location = Map.of(
                "latitude", latitudes[currentIndex],
                "longitude", longitudes[currentIndex]
        );
        currentIndex++;
        return location;
    }
}

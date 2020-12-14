package hr.fer.labpro.rassus.temperaturemicroservice.controller;

import hr.fer.labpro.rassus.temperaturemicroservice.service.CurrentReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrentReadingController {
    CurrentReadingService currentReadingService;

    @Value("${data.temperature-unit: C}")
    private String temperatureUnit;

    @Autowired
    public CurrentReadingController(CurrentReadingService currentReadingService) {
        this.currentReadingService = currentReadingService;
    }

    @Value("${data.temperature-microservice}")
    private String temperature;

    @GetMapping(value="/current-reading")
    public ResponseEntity<String> getCurrentReading() {
        Double currentTemperatureReading = this.currentReadingService.getCurrentTemperatureReading();

        return currentTemperatureReading != null ?
                ResponseEntity.ok(currentTemperatureReading.toString())
                :
                ResponseEntity.status(500).body("Reading temperature error");
    }
    @GetMapping("/pozdrav2")
    public String pozdrav2() {
        return "a ovo je temp: "+this.temperature;
    }
}

package hr.fer.labpro.rassus.temperaturemicroservice.controller;

import hr.fer.labpro.rassus.temperaturemicroservice.service.CurrentReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrentReadingController {
    CurrentReadingService currentReadingService;

    @Autowired
    public CurrentReadingController(CurrentReadingService currentReadingService) {
        this.currentReadingService = currentReadingService;
    }

    @GetMapping(value="/current-reading")
    public ResponseEntity<String> getCurrentReading() {
        Integer currentTemperatureReading = this.currentReadingService.getCurrentTemperatureReading();

        return currentTemperatureReading != null ?
                ResponseEntity.ok(currentTemperatureReading.toString())
                :
                ResponseEntity.status(500).body("Reading temperature error");
    }
}

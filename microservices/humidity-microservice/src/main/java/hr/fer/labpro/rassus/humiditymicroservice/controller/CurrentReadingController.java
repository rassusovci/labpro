package hr.fer.labpro.rassus.humiditymicroservice.controller;

import hr.fer.labpro.rassus.humiditymicroservice.service.CurrentReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrentReadingController {

    public CurrentReadingService currentReadingService;

    @Autowired
    public CurrentReadingController(CurrentReadingService currentReadingService){
        this.currentReadingService = currentReadingService;
    }

    @Value("${data.humidity-microservice}")
    private String humidity;

    @GetMapping("/current-reading")
    public ResponseEntity<String> getReading(){
        String reading = null;
        reading = currentReadingService.getReading();

        if (reading == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error");
        }
        return ResponseEntity.status(HttpStatus.OK).body(reading);
    }
    @GetMapping("/pozdrav2")
    public String pozdrav2() {
        return "ovo je hum: "+this.humidity;
    }
}

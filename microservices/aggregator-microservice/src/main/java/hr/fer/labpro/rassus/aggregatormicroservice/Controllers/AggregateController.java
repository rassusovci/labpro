package hr.fer.labpro.rassus.aggregatormicroservice.Controllers;

import hr.fer.labpro.rassus.aggregatormicroservice.Models.Measurement;
import hr.fer.labpro.rassus.aggregatormicroservice.Services.GetMeasurementsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping
public class AggregateController {
    @Autowired
    GetMeasurementsService gms;

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/readings")
    public Measurement getCurrentValues(){
        //tu ces zvat neki service vjv
        try {
            //Kasnije treba maknut ove hardkodirane URLove
            ResponseEntity<String> temperature = restTemplate.getForEntity(new URI("http://localhost:8083/current-reading"),String.class);
            ResponseEntity<String> humidity = restTemplate.getForEntity(new URI("http://localhost:8082/current-reading"),String.class);
            if(temperature.getStatusCode() != HttpStatus.OK || humidity.getStatusCode() != HttpStatus.OK){
                System.out.println("Dogodila se greska " + humidity.getStatusCode() + " " + temperature.getStatusCode());
            }
            Measurement m = new Measurement(temperature.getBody(),humidity.getBody());
            System.out.println("DOBIO SAM " + m);
            return m;
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }
}

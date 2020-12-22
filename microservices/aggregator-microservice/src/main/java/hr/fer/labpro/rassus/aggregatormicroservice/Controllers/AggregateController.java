package hr.fer.labpro.rassus.aggregatormicroservice.Controllers;

import hr.fer.labpro.rassus.aggregatormicroservice.Models.Measurement;
import hr.fer.labpro.rassus.aggregatormicroservice.Models.Pomoc;
import hr.fer.labpro.rassus.aggregatormicroservice.Services.GetMeasurementsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RefreshScope
@RequestMapping
public class AggregateController {
    @Autowired
    GetMeasurementsService gms;

    @Autowired
    RestTemplate restTemplate;
    @Autowired
    Pomoc pom;

    @Value("${proljece.datasource.pozdrav2: default}")
    private String pozdrav;

    @Value("${data.humidity-microservice}")
    private String humidity;

    @Value("${data.temperature-microservice}")
    private String temperature;

    @Value("${data.temperature-unit}")
    private String temperatureUnit;

    @GetMapping("/readings")
    public Measurement getCurrentValues(){

        try {
            ResponseEntity<String> temperature = restTemplate.getForEntity(new URI("http://"+this.temperature.trim()+"/current-reading"),String.class);
            ResponseEntity<String> humidity = restTemplate.getForEntity(new URI("http://"+this.humidity.trim()+"/current-reading"),String.class);
            if(temperature.getStatusCode() != HttpStatus.OK || humidity.getStatusCode() != HttpStatus.OK){
                System.out.println("Dogodila se greska " + humidity.getStatusCode() + " " + temperature.getStatusCode());
            }

            String temp = temperature.getBody();
            String hum = humidity.getBody() + " %";

            if(temperatureUnit.trim().toLowerCase().equals("k")) {
                Integer tempInt = Integer.parseInt(temp) + 273;
                temp = tempInt.toString() + " K";
            } else {
                temp += " C";
            }
            Measurement m = new Measurement(temp,hum);
            System.out.println("DOBIO SAM " + m);
            return m;
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }
    @GetMapping("/pozdrav")
    public String pozdrav() {
        return pozdrav;
    }
    @GetMapping("/pozdrav2")
    public String pozdrav2() {
        return "ovo je hum: "+this.humidity+", a ovo je temp: "+this.temperature+" i ovo je unit: "+this.temperatureUnit;
    }
}

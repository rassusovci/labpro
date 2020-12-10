package hr.fer.labpro.rassus.aggregatormicroservice.Controllers;

import hr.fer.labpro.rassus.aggregatormicroservice.Models.Measurement;
import hr.fer.labpro.rassus.aggregatormicroservice.Services.GetMeasurementsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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
        return new Measurement("neka temp","neki hum");
    }
}

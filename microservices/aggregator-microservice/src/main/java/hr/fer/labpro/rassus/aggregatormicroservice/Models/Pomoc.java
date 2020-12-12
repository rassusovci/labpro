package hr.fer.labpro.rassus.aggregatormicroservice.Models;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

@Component
@RefreshScope
@ConfigurationProperties(prefix="spring.datasource")
public class Pomoc {
    public String pozdrav1;
}

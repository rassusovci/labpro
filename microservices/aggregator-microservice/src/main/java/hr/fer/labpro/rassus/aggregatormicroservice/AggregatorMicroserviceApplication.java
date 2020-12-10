package hr.fer.labpro.rassus.aggregatormicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class AggregatorMicroserviceApplication {
	@Bean
	public RestTemplate gimmeRest (){
		return new RestTemplate();
	}
	public static void main(String[] args) {
		SpringApplication.run(AggregatorMicroserviceApplication.class, args);
	}

}

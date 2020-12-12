package hr.fer.labpro.rassus.aggregatormicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
//@EnableDiscoveryClient
@EnableEurekaClient
@SpringBootApplication
@RefreshScope
public class AggregatorMicroserviceApplication {
	@Bean
	@LoadBalanced
	public RestTemplate gimmeRest (){
		return new RestTemplate();
	}
	public static void main(String[] args) {
		SpringApplication.run(AggregatorMicroserviceApplication.class, args);
	}

}

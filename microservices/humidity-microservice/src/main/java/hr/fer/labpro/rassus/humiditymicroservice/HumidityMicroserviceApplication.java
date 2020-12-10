package hr.fer.labpro.rassus.humiditymicroservice;


import hr.fer.labpro.rassus.humiditymicroservice.entity.HumidityReading;
import hr.fer.labpro.rassus.humiditymicroservice.repository.HumidityRepository;
import hr.fer.labpro.rassus.humiditymicroservice.util.Parser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.LinkedList;
import java.util.List;


@SpringBootApplication
public class HumidityMicroserviceApplication implements CommandLineRunner {



	@Autowired
	private HumidityRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(HumidityMicroserviceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<String> measurements = new Parser().fillList();
		List<HumidityReading> humidityReadings = new LinkedList<>();

		int id = 0;
		for(String measurement : measurements){
			humidityReadings.add(new HumidityReading(id, measurement));
			id++;
		}

		repository.saveAll(humidityReadings);
	}
}

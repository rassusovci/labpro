package hr.fer.labpro.rassus.temperaturemicroservice;

import hr.fer.labpro.rassus.temperaturemicroservice.model.TemperatureReading;
import hr.fer.labpro.rassus.temperaturemicroservice.repository.TemperatureRepository;
import hr.fer.labpro.rassus.temperaturemicroservice.util.MeasurementFileReading;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.util.List;

@EnableDiscoveryClient
@SpringBootApplication
public class TemperatureMicroserviceApplication implements CommandLineRunner {
	@Autowired
	private TemperatureRepository repo;

	public static void main(String[] args) {
		SpringApplication.run(TemperatureMicroserviceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		this.readAndStoreTemperatures();
	}

	private void readAndStoreTemperatures() {
		// initial read temperatures on run and put them in H2
		List<TemperatureReading> temperaturesList = new MeasurementFileReading().initialReadTemperaturesFromFile();
		int index = 0;
		for (TemperatureReading reading : temperaturesList) {
			reading.setId(index++);
		}

		repo.saveAll(temperaturesList);
	}
}

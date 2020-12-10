package hr.fer.labpro.rassus.temperaturemicroservice.repository;

import hr.fer.labpro.rassus.temperaturemicroservice.model.TemperatureReading;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TemperatureRepository extends JpaRepository<TemperatureReading, Integer> {
}

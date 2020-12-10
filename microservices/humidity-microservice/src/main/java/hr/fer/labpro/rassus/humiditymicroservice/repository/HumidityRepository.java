package hr.fer.labpro.rassus.humiditymicroservice.repository;

import hr.fer.labpro.rassus.humiditymicroservice.entity.HumidityReading;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HumidityRepository extends JpaRepository<HumidityReading, Integer> {
}

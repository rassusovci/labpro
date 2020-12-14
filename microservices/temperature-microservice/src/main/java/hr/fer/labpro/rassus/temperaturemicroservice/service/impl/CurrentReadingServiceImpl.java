package hr.fer.labpro.rassus.temperaturemicroservice.service.impl;

import hr.fer.labpro.rassus.temperaturemicroservice.model.TemperatureReading;
import hr.fer.labpro.rassus.temperaturemicroservice.repository.TemperatureRepository;
import hr.fer.labpro.rassus.temperaturemicroservice.service.CurrentReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class CurrentReadingServiceImpl implements CurrentReadingService {
    @Autowired
    private TemperatureRepository repo;

    @Override
    public Double getCurrentTemperatureReading() {
        Integer id = getReadingId();
        TemperatureReading temperatureReading = this.repo.getOne(id);
        return temperatureReading.getTemperature();
    }

    public Integer getReadingId() {
        LocalDateTime now = LocalDateTime.now();
        int hour = now.getHour();
        int minute = now.getMinute();

        Integer id = 4 * hour + minute / 15;

        return id;
    }
}

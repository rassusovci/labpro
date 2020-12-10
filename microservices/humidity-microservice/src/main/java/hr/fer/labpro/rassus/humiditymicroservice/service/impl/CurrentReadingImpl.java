package hr.fer.labpro.rassus.humiditymicroservice.service.impl;

import hr.fer.labpro.rassus.humiditymicroservice.repository.HumidityRepository;
import hr.fer.labpro.rassus.humiditymicroservice.service.CurrentReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CurrentReadingImpl implements CurrentReadingService {

    @Autowired
    private HumidityRepository repository;

    @Override
    public String getReading(){

        LocalDateTime currentTime =  LocalDateTime.now();

        int hour = currentTime.getHour();
        int minutes = currentTime.getMinute();

        Integer Id = 4 * hour + (minutes / 15);

        return repository.getOne(Id).getMeasurement();

    }
}

package hr.fer.labpro.rassus.temperaturemicroservice.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TemperatureReading {
    @Id
    private Integer id;
    private Integer temperature;

    public TemperatureReading(Integer temperature) {
        this.temperature = temperature;
    }

    public TemperatureReading() {}

    public Integer getTemperature() {
        return temperature;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "TemperatureReading{" +
                "id=" + id +
                ", temperature='" + temperature + '\'' +
                '}';
    }
}
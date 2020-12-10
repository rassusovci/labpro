package hr.fer.labpro.rassus.humiditymicroservice.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class HumidityReading {
    @Id
    private Integer id;
    private String measurement;

    public HumidityReading(Integer id, String measurement) {
        this.id = id;
        this.measurement = measurement;
    }

    public HumidityReading() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMeasurement() {
        return measurement;
    }

    public void setMeasurement(String measurement) {
        this.measurement = measurement;
    }
}

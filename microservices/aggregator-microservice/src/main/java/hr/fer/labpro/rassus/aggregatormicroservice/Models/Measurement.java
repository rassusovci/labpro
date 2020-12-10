package hr.fer.labpro.rassus.aggregatormicroservice.Models;

public class Measurement {
    private String temperature;
    private String humidity;

    public Measurement(){
        this.humidity="56%";
        this.temperature="30C";
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public Measurement(String temperature, String humidity) {
        this.temperature = temperature;
        this.humidity = humidity;
    }
}

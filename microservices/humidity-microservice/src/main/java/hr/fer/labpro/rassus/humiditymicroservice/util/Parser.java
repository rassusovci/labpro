package hr.fer.labpro.rassus.humiditymicroservice.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.List;

public class Parser {
    private List<String> lines = new LinkedList<>();

    public Parser(){
        this.loadData();
    }

    private void loadData(){
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream inputStream = classloader.getResourceAsStream("data.txt");

        try (InputStreamReader streamReader =
                     new InputStreamReader(inputStream, StandardCharsets.UTF_8);
             BufferedReader reader = new BufferedReader(streamReader)) {

            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        }
        catch (IOException e){
            System.out.println(e);
        }
    }

    public List<String> fillList(){

        List<String> humidityMeasurements= new LinkedList<>();

        for(String line : this.lines){
            String measurement = line.split(",")[2];
            humidityMeasurements.add(measurement);
        }

        return humidityMeasurements;
    }
}

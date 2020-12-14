package hr.fer.labpro.rassus.temperaturemicroservice.util;

import hr.fer.labpro.rassus.temperaturemicroservice.constant.Constants;
import hr.fer.labpro.rassus.temperaturemicroservice.model.TemperatureReading;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MeasurementFileReading {
    public List<TemperatureReading> initialReadTemperaturesFromFile() {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("mjerenja.csv");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        Pattern pattern = Pattern.compile(Constants.PARSER_REGEX.getConstant());
        List<TemperatureReading> temperaturesList = new ArrayList<>();

        try {
            String line;
            while((line = bufferedReader.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                if(matcher.find()) {
                    temperaturesList.add(!matcher.group(1).equals("") ?
                            new TemperatureReading(Double.parseDouble(matcher.group(1)))
                            :
                            null);
                }
            }
            return temperaturesList;
        } catch (IOException e) {
            return null;
        }
    }

}

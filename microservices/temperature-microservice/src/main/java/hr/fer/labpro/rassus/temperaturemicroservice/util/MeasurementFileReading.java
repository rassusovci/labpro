package hr.fer.labpro.rassus.temperaturemicroservice.util;

import hr.fer.labpro.rassus.temperaturemicroservice.constant.Constants;
import hr.fer.labpro.rassus.temperaturemicroservice.model.TemperatureReading;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MeasurementFileReading {
    public List<TemperatureReading> initalReadTemperatuesFromFile() {
        String filePath = Constants.MEASUREMENTS_FILE_PATH.getConstant();
        File measurementsFile = new File(filePath);
        Pattern pattern = Pattern.compile(Constants.PARSER_REGEX.getConstant());
        List<TemperatureReading> temperaturesList = new ArrayList<>();

        try {
            List<String> measurementLinesList = Files.readAllLines(measurementsFile.toPath());
            for (String line : measurementLinesList) {
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {
                    temperaturesList.add(!matcher.group(1).equals("") ?
                            new TemperatureReading(Integer.parseInt(matcher.group(1)))
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

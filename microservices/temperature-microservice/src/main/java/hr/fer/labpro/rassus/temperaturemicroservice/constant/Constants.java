package hr.fer.labpro.rassus.temperaturemicroservice.constant;

public enum Constants {
    /**
     * Constant MEASUREMENTS_FILE_PATH (file path).
     */
    MEASUREMENTS_FILE_PATH("D:\\labpro\\microservices\\temperature-microservice\\build\\resources\\main\\mjerenja.csv"),
    /**
     * Constant MEASUREMENTS_FILE_PATH (file path).
     */
    CONFIG_FILE_PATH("D:\\labpro\\microservices\\temperature-microservice\\build\\resources\\main\\konfiguracija.txt"),
    /**
     * Constant PARSER_REGEX (regex for parsing file row).
     */
    PARSER_REGEX("^([+-]?\\d*\\.?\\d*),([+-]?\\d*\\.?\\d*),([+-]?\\d*\\.?\\d*),([+-]?\\d*\\.?\\d*),([+-]?\\d*\\.?\\d*),([+-]?\\d*\\.?\\d*),$");

    private final String constant;

    private Constants(String constant) {
        this.constant = constant;
    }
    /**
     * Getter for constant.
     *
     * @return value of this constant
     */
    public String getConstant() {
        return constant;
    }
}

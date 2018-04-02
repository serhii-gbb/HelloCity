package com.city.hello.jar_args_package;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParametersJarReader {

    private final Logger LOGGER = LoggerFactory.getLogger(ParametersJarReader.class);

    private String cityName;
    private String timeZone;


    public void readParam(String[] params) {
        cityName = params[0].trim().replaceAll("\"", "");

        if (params.length > 1) timeZone = params[1].trim();
        else timeZone = "";
        LOGGER.info("Arguments of app city:{}, time-zone:{}", cityName, timeZone.isEmpty() ? "none" : timeZone);
    }


    public String getCityName() {
        return cityName;
    }

    public String getTimeZone() {
        return timeZone;
    }
}

package com.city.hello.jar_args_package;

public class ParametersJarReader {

    private String cityName;
    private String timeZone;



    public void readParam(String[] params) {
        cityName = params[0].trim().replaceAll("\"", "");

        if (params.length > 1) timeZone = params[1].trim();
        else timeZone = "";
    }


    public String getCityName() {
        return cityName;
    }

    public String getTimeZone() {
        return timeZone;
    }
}

package com.city.hello;


import com.city.hello.enum_package.PartsOfDay;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Locale;
import java.util.ResourceBundle;

public class TimeZoneRunner {
    public static final String RESOURCES_ROOT_NAME = "greetings";

    public static void main(String[] args) {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        ParametersReader parametersReader = new ParametersReader(bufferedReader);

        TimeZoneDefiner definer = new TimeZoneDefiner(parametersReader);

        ZoneId zoneId = definer.defineTimeZone();

        String cityName = definer.getCityName();
        LocalTime zonedTime = LocalTime.now(zoneId);


//        Locale.setDefault(Locale.US);

        ResourceBundle resourceBundle = ResourceBundle.getBundle(RESOURCES_ROOT_NAME, Locale.getDefault());
        MessageManager messageManager = new MessageManager(resourceBundle);

        String greeting = messageManager.getMessage(PartsOfDay.getPart(zonedTime), cityName);

        System.out.println("--------------------------");
        System.out.println(greeting);


        try {
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

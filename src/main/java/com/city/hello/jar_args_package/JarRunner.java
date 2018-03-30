package com.city.hello.jar_args_package;

import com.city.hello.MessageManager;
import com.city.hello.TimeZoneRunner;
import com.city.hello.enum_package.PartsOfDay;

import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Locale;
import java.util.ResourceBundle;

public class JarRunner {
    public static void main(String[] args) {

        ParametersJarReader parametersJarReader = new ParametersJarReader();
        parametersJarReader.readParam(args);

        String cityName = parametersJarReader.getCityName();
        String timeZone = parametersJarReader.getTimeZone();

        ZoneId timeZoneId = TimeZoneJarDefiner.getTimeZone(cityName, timeZone);


        ResourceBundle resourceBundle = ResourceBundle
                .getBundle(TimeZoneRunner.RESOURCES_ROOT_NAME, Locale.getDefault());
        MessageManager messageManager = new MessageManager(resourceBundle);

        LocalTime zonedTime = LocalTime.now(timeZoneId);
        String message = messageManager.getMessage(PartsOfDay.getPart(zonedTime), cityName);



        System.out.println("---------------------------------");
        System.out.println(message);

    }
}

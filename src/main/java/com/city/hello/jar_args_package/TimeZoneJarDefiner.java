package com.city.hello.jar_args_package;

import com.city.hello.TimeZoneDefiner;

import java.time.ZoneId;

public class TimeZoneJarDefiner {



    public static ZoneId getTimeZone(String city, String timeZone) {
        String formatCity = city.replaceAll("\\s", "_");
        for (String loopZone : ZoneId.getAvailableZoneIds()) {

            if (timeZone.isEmpty() && loopZone.contains(formatCity)) {
                return ZoneId.of(loopZone);

            } else if (!timeZone.isEmpty() && loopZone.contains(timeZone)) {
                return ZoneId.of(loopZone);

            }

        }

        return TimeZoneDefiner.DEFAULT_TIME_ZONE;


    }

}

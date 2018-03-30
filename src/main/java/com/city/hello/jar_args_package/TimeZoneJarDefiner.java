package com.city.hello.jar_args_package;

import com.city.hello.TimeZoneDefiner;

import java.time.ZoneId;

public class TimeZoneJarDefiner {



    public static ZoneId getTimeZone(String city, String timeZone) {

        for (String loopZone : ZoneId.getAvailableZoneIds()) {

            if (timeZone.isEmpty() && loopZone.contains(city)) {
                return ZoneId.of(loopZone);

            } else if (!timeZone.isEmpty() && loopZone.contains(timeZone)) {
                return ZoneId.of(loopZone);

            }

        }

        return TimeZoneDefiner.DEFAULT_TIME_ZONE;


    }

}

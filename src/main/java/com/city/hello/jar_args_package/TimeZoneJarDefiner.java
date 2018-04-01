package com.city.hello.jar_args_package;

import com.city.hello.TimeZoneDefiner;

import java.time.ZoneId;
import java.util.Arrays;

public class TimeZoneJarDefiner {


    public static ZoneId getTimeZone(String city, String timeZone) {
        String formatCity = city.replaceAll("\\s", "_");

        for (String loopZone : ZoneId.getAvailableZoneIds()) {
            String[] splitZone = loopZone.split("/");

            if (timeZone.isEmpty() && Arrays.stream(splitZone).anyMatch(s-> s.equals(formatCity))) {
                return ZoneId.of(loopZone);

            } else if (loopZone.equals(timeZone)) {
                return ZoneId.of(loopZone);

            }

        }

        return TimeZoneDefiner.DEFAULT_TIME_ZONE;


    }

}

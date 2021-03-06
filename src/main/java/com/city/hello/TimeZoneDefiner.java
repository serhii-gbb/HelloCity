package com.city.hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.ZoneId;
import java.time.zone.ZoneRulesException;
import java.util.Arrays;

public class TimeZoneDefiner {

    public static final ZoneId DEFAULT_TIME_ZONE = ZoneId.of("GMT");
    private final Logger LOGGER = LoggerFactory.getLogger(TimeZoneDefiner.class);

    private ParametersReader parametersReader;
    private String cityName;

    public TimeZoneDefiner(ParametersReader parametersReader) {
        this.parametersReader = parametersReader;
    }


    public ZoneId defineTimeZone() {

        cityName = parametersReader.readCity();
        String zoneCity = cityName.replaceAll("\\s", "_");

        while (true) {
            try {
                String timeZone = parametersReader.readTimeZone();

                for (String loopZone : ZoneId.getAvailableZoneIds()) {

                    String[] splitZone = loopZone.split("/");

                    if (Arrays.stream(splitZone).anyMatch(z -> z.equals(zoneCity))) {

                        if (splitZone[0].equals(timeZone) || timeZone.isEmpty() || splitZone.length == 1)
                            return ZoneId.of(loopZone);
                        else
                            throw new ZoneRulesException("ОШИБКА ВВОДА!!! Неправильный часовой пояс для этого города!");

                    }
                }

            } catch (ZoneRulesException e) {
                LOGGER.info(e.getMessage());
                continue;
            }

            return DEFAULT_TIME_ZONE;
        }

    }


    public String getCityName() {
        return cityName;
    }

}

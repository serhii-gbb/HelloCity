package com.city.hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.ZoneId;
import java.time.zone.ZoneRulesException;
import java.util.Arrays;

public class TimeZoneDefiner {

    private final ZoneId DEFAULT_TIME_ZONE = ZoneId.of("GMT");
    private final Logger logger = LoggerFactory.getLogger(TimeZoneDefiner.class);

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

                    if (Arrays.stream(splitZone).anyMatch(z -> z.equals(zoneCity)) && splitZone.length > 1) {

                        if (splitZone[0].equals(timeZone) || timeZone.isEmpty())
                            return ZoneId.of(loopZone);
                        else
                            throw new ZoneRulesException("ОШИБКА ВВОДА!!! Неправильный часовой пояс для этого города!");

                    }
                }

            } catch (ZoneRulesException e) {
                logger.info(e.getMessage());
                continue;
            }

            return DEFAULT_TIME_ZONE;
        }

    }


    public String getCityName() {
        return cityName;
    }

}

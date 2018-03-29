package com.city.hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.ZoneId;
import java.time.zone.ZoneRulesException;

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

        while (true) {
            try {
               String timeZone = parametersReader.readTimeZone();

                for (String zoneId : ZoneId.getAvailableZoneIds()) {

                    if (zoneId.contains(cityName.replaceAll("\\s", "_"))) {

                        if (zoneId.contains(timeZone) || timeZone.isEmpty()) {
                            return ZoneId.of(zoneId);
                        } else
                            throw new ZoneRulesException("Неправильный часовой пояс для этого города!");

                    }
                }

            } catch (ZoneRulesException e) {
                logger.info("ОШИБКА ВВОДА!!! " + e.getMessage());
                continue;
            }

            return DEFAULT_TIME_ZONE;
        }

    }



    public String getCityName() {
        return cityName;
    }

}

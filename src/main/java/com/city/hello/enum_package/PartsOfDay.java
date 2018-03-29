package com.city.hello.enum_package;

import java.time.LocalTime;
import java.util.function.Predicate;

public enum PartsOfDay {

    MORNING(time -> time.getHour() >= 6 && time.getHour() < 9),
    DAY(time -> time.getHour() >= 9 && time.getHour() < 19),
    EVENING(time -> time.getHour() >= 19 && time.getHour() < 23),
    NIGHT(time -> time.getHour() >= 23 || time.getHour() < 6);

    private Predicate<LocalTime> timePredicate;


    PartsOfDay(Predicate<LocalTime> timePredicate) {
        this.timePredicate = timePredicate;
    }


    public static PartsOfDay getPart(LocalTime time) {
        PartsOfDay part = null;

        for (PartsOfDay partOfDay : PartsOfDay.values()) {

            if (partOfDay.timePredicate.test(time)) {
                part = partOfDay;
            }
        }

        return part;
    }
}

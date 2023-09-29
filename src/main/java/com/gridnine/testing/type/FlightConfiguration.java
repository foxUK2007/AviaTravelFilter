package com.gridnine.testing.type;

import com.gridnine.testing.filter.FlightFilter;
import com.gridnine.testing.filter.LandingBeforeTakeOff;
import com.gridnine.testing.filter.TakeOffBeforePresentTime;
import com.gridnine.testing.filter.TimeSpentOnEarthMore2Hours;

public class FlightConfiguration {

    /**
     * Метод создания правил фильтрации
     *
     * @param type тип правила относительно даты взлёта и приземления
     * @return
     */
    public static FlightFilter createFlightFilterByType(String type) {
        switch (type) {
            case ("landBeforeTake"):
                return new LandingBeforeTakeOff();
            case ("takeBeforePT"):
                return new TakeOffBeforePresentTime();
            case ("more2Hours"):
                return new TimeSpentOnEarthMore2Hours();
            default:
                return null;
        }
    }
}
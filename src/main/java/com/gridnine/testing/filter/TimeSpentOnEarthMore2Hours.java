package com.gridnine.testing.filter;

import com.gridnine.testing.entity.Flight;
import com.gridnine.testing.entity.Segment;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class TimeSpentOnEarthMore2Hours implements FlightFilter{

    /**
     * Метод проверки рейсов, на которых общее время посадки между сегментами меньше или равно максимально допустимому времени посадки
     *
     * @param flight список рейсов, подлежащих фильтрации
     * @return
     */
    @Override
    public boolean checkFlight(Flight flight) {
        if (flight.getSegments().size() > 1) {
            List<Segment> segments = flight.getSegments();
            int expectation = 0;
            int count = 0;
            for (int i = 0; i < segments.size() - 1; i++) {
                LocalDateTime landing = segments.get(i).getLandingDate();
                LocalDateTime nextTakeOff = segments.get(i + 1).getTakeOffDate();
                expectation += (int) landing.until(nextTakeOff, ChronoUnit.MINUTES);
                count++;
                if (count == segments.size() - 1) return expectation / 60 <= 2;
            }
        }
        return false;
    }
}


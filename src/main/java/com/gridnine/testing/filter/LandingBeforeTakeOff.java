package com.gridnine.testing.filter;

import com.gridnine.testing.entity.Flight;
import com.gridnine.testing.entity.Segment;

import java.time.LocalDateTime;
import java.util.List;

public class LandingBeforeTakeOff implements FlightFilter{
    @Override
    public boolean checkFlight(Flight flight) {
        /**
         * Метод проверки рейса из одного сегмента
         */
        if (flight.getSegments().size() == 1) {
            Segment segment = flight.getSegments().get(0);
            LocalDateTime landing = segment.getLandingDate();
            LocalDateTime takeOff = segment.getTakeOffDate();
            if (landing.isBefore(takeOff)) {
                return false;
            }
        } else {
            /**
             * Метод проверки рейса из многих сегментов
             */
            List<Segment> segments = flight.getSegments();
            for (int i = 0; i < segments.size() - 1; i++) {
                LocalDateTime landing = segments.get(i).getLandingDate();
                LocalDateTime takeOff = segments.get(i).getTakeOffDate();
                LocalDateTime nextSegment = segments.get(i + 1).getTakeOffDate();
                /**
                 * Метод проверки рейса, если взлет после приземления  или приземление после взлёта следующего сегмента
                 */
                if (takeOff.isAfter(landing) || landing.isAfter(nextSegment))
                    return false;
            }
        }
        return true;
    }
}

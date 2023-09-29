package com.gridnine.testing.filter;

import com.gridnine.testing.entity.Flight;
import com.gridnine.testing.entity.Segment;

import java.time.LocalDateTime;

public class TakeOffBeforePresentTime implements FlightFilter{

    /**
     * Метод проверки рейсов, на которых все сегменты имеют дату взлёта после текущего времени
     *
     * @param flight список рейсов, подлежащих фильтрации
     * @return
     */

    @Override
    public boolean checkFlight(Flight flight) {
            for (Segment segment : flight.getSegments()) {
                if (segment.getTakeOffDate().isBefore(LocalDateTime.now()))
                    return false;
            }
            return true;
        }
    }

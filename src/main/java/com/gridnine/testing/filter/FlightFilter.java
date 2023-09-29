package com.gridnine.testing.filter;

import com.gridnine.testing.entity.Flight;

public interface FlightFilter {

    /**
     * Метод фильтрации списка рейсов на основе определенных критериев.
     *
     * @param flight список рейсов, подлежащих фильтрации
     * @return отфильтрованный список рейсов
     */

    boolean checkFlight(Flight flight);
}
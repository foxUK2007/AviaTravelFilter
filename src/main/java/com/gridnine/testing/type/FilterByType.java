package com.gridnine.testing.type;

import com.gridnine.testing.entity.Flight;
import com.gridnine.testing.entity.FlightBuilder;
import com.gridnine.testing.filter.FlightFilter;

import java.util.List;
import java.util.stream.Collectors;

public class FilterByType {

    /**
     * метод для фильтрации полетов, можно использовать сразу несколько фильтров
     */
    public static List<Flight> flightFilter(String... types) {
        List<Flight> flights = FlightBuilder.createFlights();
        for (String type : types) {
            FlightFilter flightFilter = FlightConfiguration.createFlightFilterByType(type);
            flights = flights.stream().filter(flightFilter::checkFlight).collect(Collectors.toList());
        }
        return flights;
    }
}

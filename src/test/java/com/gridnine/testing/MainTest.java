package com.gridnine.testing;

import com.gridnine.testing.entity.Flight;
import com.gridnine.testing.entity.FlightBuilder;
import com.gridnine.testing.filter.FlightFilter;
import com.gridnine.testing.type.FlightConfiguration;
import org.junit.jupiter.api.Assertions;
import org.junit.Test;

import java.util.List;

public class MainTest {

    List<Flight> flights = FlightBuilder.createFlights();

    /**
     * Проверка, если рейсов после взлета до текущего момента времени должно быть на один меньше
     */

    @Test
    public void WhenFlightAfterTakeOffBeforePresentTimeLessOnOne() {
        FlightFilter flightFilter = FlightConfiguration.createFlightFilterByType("takeBeforePT");
        int actual = (int) flights.stream().filter(flightFilter::checkFlight).count();
        int expected = flights.size() - 1;
        Assertions.assertEquals(actual, expected);
    }

    /**
     * Проверка, если рейсов после приземления до текущего момента времени должно быть на один меньше
     */

    @Test
    public void WhenFlightAfterLandingBeforePresentTimeLessOnOne() {
        FlightFilter flightFilter = FlightConfiguration.createFlightFilterByType("takeBeforePT");
        int actual = (int) flights.stream().filter(flightFilter::checkFlight).count();
        int expected = flights.size() - 1;
        Assertions.assertEquals(actual, expected);
    }

    /**
     * Проверка, если рейсов после более чем двухчасового ожидания должно быть на 5 меньше
     */

    @Test
    public void WhenFlightsAfterMoreThanTwoHoursExpectation() {
        FlightFilter flightFilter = FlightConfiguration.createFlightFilterByType("more2Hours");
        int actual = (int) flights.stream().filter(flightFilter::checkFlight).count();
        int expected = flights.size() - 5;
        Assertions.assertEquals(actual, expected);
    }
}


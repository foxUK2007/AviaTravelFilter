package com.gridnine.testing.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlightBuilder {

    public static List<Flight> createFlights() {
        LocalDateTime threeDaysFromNow = LocalDateTime.now().plusDays(3);
        return Arrays.asList(
                /**
                 * Рейс продолжительностью два часа
                 */
                createFlight(threeDaysFromNow, threeDaysFromNow.plusHours(2)),
                /**
                 * Многосегментный рейс
                 */
                createFlight(threeDaysFromNow, threeDaysFromNow.plusHours(2),
                        threeDaysFromNow.plusHours(3), threeDaysFromNow.plusHours(5)),
                /**
                 * Рейс, совершенный ранее
                 */
                createFlight(threeDaysFromNow.minusDays(6), threeDaysFromNow),
                /**
                 * Рейс с датой прилёта раньше даты вылета
                 */
                createFlight(threeDaysFromNow, threeDaysFromNow.minusHours(6)),
                /**
                 * Рейс, где время, проведённое на земле превышает два часа
                 */
                createFlight(threeDaysFromNow, threeDaysFromNow.plusHours(2),
                        threeDaysFromNow.plusHours(5), threeDaysFromNow.plusHours(6)),
                /**
                 * Ещё один рейс, где время, проведённое на земле превышает два часа
                 */
                createFlight(threeDaysFromNow, threeDaysFromNow.plusHours(2),
                        threeDaysFromNow.plusHours(3), threeDaysFromNow.plusHours(4),
                        threeDaysFromNow.plusHours(6), threeDaysFromNow.plusHours(7)));
    }

    private static Flight createFlight(final LocalDateTime... dates) {
        if ((dates.length % 2) != 0) {
            throw new IllegalArgumentException(
                    "Укажите дату, кратную 2");
        }
        List<Segment> segments = new ArrayList<>(dates.length / 2);
        for (int i = 0; i < (dates.length - 1); i += 2) {
            segments.add(new Segment(dates[i], dates[i + 1]));
        }
        return new Flight(segments);
    }
}

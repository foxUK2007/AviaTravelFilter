package com.gridnine.testing.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 * Бин, представляющий сегмент рейса.
 */
public class Segment {

    private final LocalDateTime takeOffDate;

    private final LocalDateTime landingDate;

    Segment(final LocalDateTime tOD, final LocalDateTime lD) {
        takeOffDate = Objects.requireNonNull(tOD);
        landingDate = Objects.requireNonNull(lD);
    }

    public LocalDateTime getTakeOffDate() {
        return takeOffDate;
    }

    public LocalDateTime getLandingDate() {
        return landingDate;
    }

    @Override
    public String toString() {
        DateTimeFormatter fmt =
                DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        return '[' + takeOffDate.format(fmt) + '|' + landingDate.format(fmt)
                + ']';
    }
}

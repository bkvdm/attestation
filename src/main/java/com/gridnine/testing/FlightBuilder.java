package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Класс для получения примерного списка рейсов.
 */
public class FlightBuilder {
    static List<Flight> createFlights() {
        LocalDateTime threeDaysFromNow = LocalDateTime.now().plusDays(3);
        return Arrays.asList(
                // Обычный полет продолжительностью два часа
                createFlight(threeDaysFromNow, threeDaysFromNow.plusHours(2)),
                // Обычный многосегментный полёт
                createFlight(threeDaysFromNow, threeDaysFromNow.plusHours(2),
                        threeDaysFromNow.plusHours(3), threeDaysFromNow.plusHours(5)),
                // Рейс, вылетающий в прошлом
                createFlight(threeDaysFromNow.minusDays(6), threeDaysFromNow),
                // Рейс, который вылетает до прибытия
                createFlight(threeDaysFromNow, threeDaysFromNow.minusHours(6)),
                // Рейс с наземным временем более двух часов
                createFlight(threeDaysFromNow, threeDaysFromNow.plusHours(2),
                        threeDaysFromNow.plusHours(5), threeDaysFromNow.plusHours(6)),
                // Еще один рейс с наземным временем более двух часов
                createFlight(threeDaysFromNow, threeDaysFromNow.plusHours(2),
                        threeDaysFromNow.plusHours(3), threeDaysFromNow.plusHours(4),
                        threeDaysFromNow.plusHours(6), threeDaysFromNow.plusHours(7)));
    }

    private static Flight createFlight(final LocalDateTime... dates) {
        if ((dates.length % 2) != 0) {
            throw new IllegalArgumentException(
                    "Вы должны пройти чётное количество дат");
        }
        List<Segment> segments = new ArrayList<>(dates.length / 2);
        for (int i = 0; i < (dates.length - 1); i += 2) {
            segments.add(new Segment(dates[i], dates[i + 1]));
        }
        return new Flight(segments);
    }
}

package com.gridnine.testing;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Фильтр, исключающий рейсы, где ожидание вылета больше двух часов.
 */
public class ExcludeLongGroundTime {

    private static final long MAX_WAIT_MINUTES = 120;

    public List<Flight> apply(List<Flight> flights) {
        return flights.parallelStream()
                .filter(flight -> {
                    List<Segment> segments = flight.getSegments();
                    long totalWaitMinutes = 0;

                    for (int i = 1; i < segments.size(); i++) {
                        Segment previous = segments.get(i - 1);
                        Segment next = segments.get(i);

                        // Расчёт времени ожидания между сегментами в минутах
                        long waitMinutes = Duration.between(previous.getArrivalDate(), next.getDepartureDate()).toMinutes();
                        totalWaitMinutes += waitMinutes; // Суммируем общее время ожидания
                    }

                    // Проверка, что общее время ожидания не превышает 2 часов
                    if (totalWaitMinutes > MAX_WAIT_MINUTES) {
                        // Логирование причин исключения рейса из списка
                        System.out.println("Рейс исключён из-за общего времени ожидания между сегментами, больше 2 часов.");
                        System.out.println("Общее время ожидания: " + totalWaitMinutes + " минут (превышает 2 часа).");
                        return false; // Рейс исключается
                    }

                    return true; // Рейс проходит фильтрацию
                })
                .collect(Collectors.toList());
    }
}

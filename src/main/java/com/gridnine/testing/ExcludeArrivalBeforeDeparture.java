package com.gridnine.testing;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Фильтр, исключающий рейсы, у которых прибытие происходит раньше вылета
 */
public class ExcludeArrivalBeforeDeparture {

    public List<Flight> apply(List<Flight> flights) {

        // Открытие потока для обработки списка рейсов.
        return flights.parallelStream()

                // Фильтрация тех рейсов, у которых все сегменты имеют прибытие позже вылета.
                .filter(flight -> {
                    // Создание потока для сегментов текущего рейса.
                    return flight.getSegments().stream()

                            // Проверка времени прибытия каждого сегмента рейса, позднее времени вылета.
                            .allMatch(segment -> segment.getArrivalDate().isAfter(segment.getDepartureDate()));
                })

                // Сборка отфильтрованных рейсов обратно в список (List<Flight>).
                .collect(Collectors.toList());
    }
}

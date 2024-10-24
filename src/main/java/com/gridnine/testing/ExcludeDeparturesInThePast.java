package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Фильтр, исключающий рейсы с вылетом, которые состоялись в прошлом
 */
public class ExcludeDeparturesInThePast {

    public List<Flight> apply(List<Flight> flights) {
        // Открытие потока рейсов
        return flights.parallelStream()

                // Применение фильтра, который оставляем только те рейсы, у которых все сегменты имеют вылет в будущем
                .filter(flight -> {
                    // Создание потока сегментов текущего рейса
                    return flight.getSegments().stream()
                            // Проверка, что каждый сегмент вылетает после текущего момента
                            .allMatch(segment -> segment.getDepartureDate().isAfter(LocalDateTime.now()));
                })

                // Сборка отфильтрованных рейсов обратно в список
                .collect(Collectors.toList());
    }
}

package com.gridnine.testing;

import java.time.Duration;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Метод, исключающий рейсы, где пассажир проводит на земле в ожидании вылета больше указанного количества часов.
 * Если время ожидания между сегментами >= 24 часа, приводит к исключению (так как это значение считается остановкой в пути).
 */
public class ExcludeLongGroundTime {

    public List<Flight> apply(List<Flight> flights, Optional<Byte> hoursGroundOptional) {
        if (hoursGroundOptional.isEmpty()) {
            return flights; // Никакая фильтрация не применяется
        }

        byte hoursGround = hoursGroundOptional.get();
        if (hoursGround > 24) {
            throw new IllegalArgumentException("Время ожидания не может превышать 24 часа.");
        }

        long maxWaitMinutes = hoursGround * 60;

        return flights.parallelStream()
                .filter(flight -> {
                    List<Segment> segments = flight.getSegments();
                    boolean isValidFlight = true;

                    for (int i = 1; i < segments.size(); i++) {
                        Segment previous = segments.get(i - 1);
                        Segment next = segments.get(i);

                        // Расчёт времени ожидания между сегментами в минутах
                        long waitMinutes = Duration.between(previous.getArrivalDate(), next.getDepartureDate()).toMinutes();

                        // Проверка условий фильтрации
                        boolean isValidSegment = waitMinutes >= 60 && waitMinutes <= maxWaitMinutes &&
                                previous.getArrivalDate().isBefore(next.getDepartureDate());

                        // Логирование причин исключения рейса из списка
                        if (!isValidSegment) {
                            System.out.println("Рейс исключен: " + flight);
                            System.out.println("Проблема в сегментах: " + previous + " (прибытие) -> " + next + " (вылет)");
                            System.out.println("Время ожидания: " + waitMinutes + " минут");
                        }

                        if (!isValidSegment) {
                            isValidFlight = false; // Рейс недействителен
                            break; // Прерывание цикл
                        }
                    }
                    return isValidFlight; // Возрат результата проверки
                })
                .collect(Collectors.toList());
    }
}

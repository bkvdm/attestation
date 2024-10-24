package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestFlightData {

    public static List<Flight> createTestFlights() {
        Segment segment1 = new Segment(LocalDateTime.of(2024, 10, 15, 6, 0), LocalDateTime.of(2024, 10, 15, 6, 50));   // 50 минут в полёте
        Segment segment2 = new Segment(LocalDateTime.of(2024, 10, 15, 8, 0), LocalDateTime.of(2024, 10, 15, 9, 10));   // 1 час 10 минут в полёте
        Segment segment3 = new Segment(LocalDateTime.of(2024, 10, 15, 10, 0), LocalDateTime.of(2024, 10, 15, 14, 0));  // 4 часа в полёте
        Segment segment4 = new Segment(LocalDateTime.of(2024, 10, 15, 13, 0), LocalDateTime.of(2024, 10, 15, 20, 0));  // 7 часов в полёте
        Segment segment5 = new Segment(LocalDateTime.of(2024, 10, 15, 16, 0), LocalDateTime.of(2024, 10, 15, 16, 50)); // 50 минут в полёте
        Segment segment6 = new Segment(LocalDateTime.of(2024, 10, 15, 17, 0), LocalDateTime.of(2024, 10, 15, 18, 30)); // 1 час 30 минут в полёте
        Segment segment7 = new Segment(LocalDateTime.of(2024, 10, 15, 19, 0), LocalDateTime.of(2024, 10, 15, 22, 0));  // 3 часа в полёте
        Segment segment8 = new Segment(LocalDateTime.of(2024, 10, 15, 23, 0), LocalDateTime.of(2024, 10, 16, 5, 30));  // 6 часов 30 минут в полёте
        Segment segment9 = new Segment(LocalDateTime.of(2024, 10, 16, 6, 0), LocalDateTime.of(2024, 10, 16, 10, 30));  // 4 часа 30 минут в полёте
        Segment segment10 = new Segment(LocalDateTime.of(2024, 10, 16, 11, 0), LocalDateTime.of(2024, 10, 16, 16, 0)); // 5 часов в полёте

        Segment segment11 = new Segment(LocalDateTime.of(2024, 10, 16, 17, 0), LocalDateTime.of(2024, 10, 16, 21, 50)); // 4 часа 50 минут в полёте
        Segment segment12 = new Segment(LocalDateTime.of(2024, 10, 16, 22, 0), LocalDateTime.of(2024, 10, 17, 5, 0));   // 7 часов в полёте
        Segment segment13 = new Segment(LocalDateTime.of(2024, 10, 17, 6, 0), LocalDateTime.of(2024, 10, 17, 9, 50));   // 3 часа 50 минут в полёте
        Segment segment14 = new Segment(LocalDateTime.of(2024, 10, 17, 10, 0), LocalDateTime.of(2024, 10, 17, 17, 30)); // 7 часов 30 минут в полёте
        Segment segment15 = new Segment(LocalDateTime.of(2024, 10, 17, 18, 0), LocalDateTime.of(2024, 10, 18, 1, 0));   // 7 часов в полёте
        Segment segment16 = new Segment(LocalDateTime.of(2024, 10, 18, 2, 0), LocalDateTime.of(2024, 10, 18, 6, 0));    // 4 часа в полёте
        Segment segment17 = new Segment(LocalDateTime.of(2024, 10, 18, 7, 0), LocalDateTime.of(2024, 10, 18, 12, 0));   // 5 часов в полёте
        Segment segment18 = new Segment(LocalDateTime.of(2024, 10, 18, 13, 0), LocalDateTime.of(2024, 10, 18, 19, 0));  // 6 часов в полёте
        Segment segment19 = new Segment(LocalDateTime.of(2024, 10, 18, 20, 0), LocalDateTime.of(2024, 10, 18, 23, 0));  // 3 часа в полёте
        Segment segment20 = new Segment(LocalDateTime.of(2024, 10, 18, 23, 0), LocalDateTime.of(2024, 10, 19, 7, 0));   // 8 часов в полёте

        // Дополнительные сегменты с временем от 2 до 2 часов 45 минут
        Segment segment21 = new Segment(LocalDateTime.of(2024, 10, 15, 9, 0), LocalDateTime.of(2024, 10, 15, 11, 15));  // 2 часа 15 минут в полёте
        Segment segment22 = new Segment(LocalDateTime.of(2024, 10, 16, 12, 30), LocalDateTime.of(2024, 10, 16, 14, 45)); // 2 часа 15 минут в полёте
        Segment segment23 = new Segment(LocalDateTime.of(2024, 10, 17, 8, 45), LocalDateTime.of(2024, 10, 17, 11, 30));  // 2 часа 45 минут в полёте
        Segment segment24 = new Segment(LocalDateTime.of(2024, 10, 17, 14, 0), LocalDateTime.of(2024, 10, 17, 16, 0));   // 2 часа в полёте
        Segment segment25 = new Segment(LocalDateTime.of(2024, 10, 18, 15, 30), LocalDateTime.of(2024, 10, 18, 17, 45));  // 2 часа 15 минут в полёте
        Segment segment26 = new Segment(LocalDateTime.of(2023, 10, 15, 8, 0), LocalDateTime.of(2023, 10, 15, 9, 0));   // Вылет в прошлом
        Segment segment27 = new Segment(LocalDateTime.of(2024, 10, 15, 10, 0), LocalDateTime.of(2024, 10, 15, 14, 0));  // 4 часа в полёте
        Segment segment28 = new Segment(LocalDateTime.of(2024, 10, 15, 16, 0), LocalDateTime.of(2024, 10, 15, 16, 50)); // 50 минут в полёте
        Segment segment29 = new Segment(LocalDateTime.of(2024, 10, 15, 23, 0), LocalDateTime.of(2024, 10, 16, 5, 30));   // 6 часов 30 минут в полёте

        Segment pastSegment1 = new Segment(LocalDateTime.of(2023, 10, 15, 6, 0), LocalDateTime.of(2023, 10, 15, 7, 0));   // Вылет в прошлом
        Segment futureSegment1 = new Segment(LocalDateTime.of(2024, 10, 16, 10, 0), LocalDateTime.of(2024, 10, 16, 12, 0)); // Вылет в будущем
        Segment futureSegment2 = new Segment(LocalDateTime.of(2024, 10, 17, 14, 0), LocalDateTime.of(2024, 10, 17, 16, 0)); // Вылет в будущем
        Segment mixedSegment1 = new Segment(LocalDateTime.of(2023, 10, 14, 18, 0), LocalDateTime.of(2023, 10, 14, 20, 0));  // Вылет в прошлом
        Segment mixedSegment2 = new Segment(LocalDateTime.of(2024, 10, 16, 6, 0), LocalDateTime.of(2024, 10, 16, 8, 0));   // Вылет в будущем

        Segment segmentLongTime0 = new Segment(LocalDateTime.of(2024, 10, 15, 6, 0), LocalDateTime.of(2024, 10, 15, 6, 50));   // 50 минут в полёте
        Segment segmentLongTime1 = new Segment(LocalDateTime.of(2024, 10, 15, 8, 0), LocalDateTime.of(2024, 10, 15, 9, 10));   // 1 час 10 минут в полёте
        Segment segmentLongTime4 = new Segment(LocalDateTime.of(2024, 10, 15, 17, 0), LocalDateTime.of(2024, 10, 15, 18, 30)); // 1 час 30 минут в полёте
        Segment segmentLongTime5 = new Segment(LocalDateTime.of(2024, 10, 15, 19, 0), LocalDateTime.of(2024, 10, 15, 22, 0));  // 3 часа в полёте

        // Рейсы для фильтра: ExcludeArrivalBeforeDeparture
        Flight flight2 = new Flight(Arrays.asList(segment3, segment4, segment5)); // Второй рейс с тремя сегментами

        // Рейсы для фильтра: ExcludeDeparturesInThePast
        Flight flight5 = new Flight(Arrays.asList(pastSegment1, futureSegment1)); // Рейс с сегментом из прошлого
        Flight flight6 = new Flight(Arrays.asList(futureSegment1, futureSegment2)); // Рейс с сегментами в будущем
        Flight flight7 = new Flight(Arrays.asList(mixedSegment1, mixedSegment2)); // Рейс с сегментом из прошлого и будущего

        // Рейсы для фильтра: ExcludeLongGroundTime
        Flight flightLongTime1 = new Flight(Arrays.asList(segmentLongTime0, segmentLongTime1));
        Flight flightLongTime2 = new Flight(Arrays.asList(segmentLongTime0, segmentLongTime4, segmentLongTime5));
        Flight flightLongTime3 = new Flight(Arrays.asList(segmentLongTime0, segmentLongTime1, segmentLongTime4));

        // Рейсы, которые не попадут под условия фильтров
        Flight flight4 = new Flight(Arrays.asList(segment8, segment9, segment10)); // Четвертый рейс с тремя сегментами
        Flight flight1 = new Flight(Arrays.asList(segment1, segment2)); // Первый рейс с двумя сегментами
        Flight flight3 = new Flight(Arrays.asList(segment6, segment7)); // Третий рейс с двумя сегментами
        Flight flightFree0 = new Flight(List.of(segment1)); // 50 минут в полёте
        Flight flightFree1 = new Flight(Arrays.asList(segment2, segment5));  // 1 час 10 минут в полёте и 50 минут в полёте
        Flight flightFree2 = new Flight(Arrays.asList(segment6, segment4, segment3));// 1 час 30 минут в полёте, 7 часов в полёте и 4 часа в полёте
        Flight flightFree3 = new Flight(Arrays.asList(segment8, segment9, segment10, segment11)); // 6 часов 30 минут в полёте, 4 часа 30 минут в полёте, 5 часов в полёте и 4 часа 50 минут в полёте
        Flight flightFree4 = new Flight(Arrays.asList(segment12, segment13, segment21)); // 7 часов в полёте, 3 часа 50 минут в полёте, 2 часа 15 минут в полёте
        Flight flightFree5 = new Flight(List.of(segment14));
        Flight flightFree6 = new Flight(List.of(segment15));
        Flight flightFree7 = new Flight(List.of(segment16));
        Flight flightFree8 = new Flight(List.of(segment17));
        Flight flightFree9 = new Flight(List.of(segment18));
        Flight flightFree10 = new Flight(List.of(segment19));
        Flight flightFree11 = new Flight(List.of(segment20));
        Flight flightFree12 = new Flight(List.of(segment22));
        Flight flightFree13 = new Flight(List.of(segment23));
        Flight flightFree14 = new Flight(List.of(segment24));
        Flight flightFree15 = new Flight(List.of(segment25));
        Flight flightFree16 = new Flight(List.of(segment26));
        Flight flightFree17 = new Flight(List.of(segment27));
        Flight flightFree18 = new Flight(List.of(segment28));
        Flight flightFree19 = new Flight(List.of(segment29));

        return Arrays.asList(
                flight1, flight2, flight3, flight4, flight5, flight6, flight7,
                flightLongTime1, flightLongTime2, flightLongTime3,
                flightFree0, flightFree1, flightFree2, flightFree3, flightFree4, flightFree5,
                flightFree6, flightFree7, flightFree8, flightFree9, flightFree10, flightFree11,
                flightFree12, flightFree13, flightFree14, flightFree15, flightFree16, flightFree17,
                flightFree18, flightFree19
        );
    }

    private static Segment createSegment(LocalDateTime departure, LocalDateTime arrival) {
        return new Segment(departure, arrival);
    }

    public static List<Flight> createTestFlightsForArrivalBeforeDeparture() {
        List<Flight> flights = new ArrayList<>();

        // 1. Рейс с 2 сегментами (прибытие раньше вылета)
        flights.add(createFlight(
                createSegment(LocalDateTime.of(2024, 10, 20, 11, 0), LocalDateTime.of(2024, 10, 20, 9, 0)), // Неверные данные
                createSegment(LocalDateTime.of(2024, 10, 20, 12, 0), LocalDateTime.of(2024, 10, 20, 10, 0))
        ));

        // 2. Рейс с 3 сегментами (эти сегменты должны пройти и не должны быть отфильтрованы)
        flights.add(createFlight(
                createSegment(LocalDateTime.of(2024, 10, 21, 10, 0), LocalDateTime.of(2024, 10, 21, 12, 0)),
                createSegment(LocalDateTime.of(2024, 10, 21, 14, 0), LocalDateTime.of(2024, 10, 21, 16, 0)),
                createSegment(LocalDateTime.of(2024, 10, 21, 17, 0), LocalDateTime.of(2024, 10, 21, 18, 0))
        ));

        // 3. Рейс с 4 сегментами (ошибка в сегменте, для фильтра)
        flights.add(createFlight(
                createSegment(LocalDateTime.of(2024, 10, 22, 6, 0), LocalDateTime.of(2024, 10, 22, 7, 0)),
                createSegment(LocalDateTime.of(2024, 10, 22, 8, 0), LocalDateTime.of(2024, 10, 22, 7, 45)), // Ошибка
                createSegment(LocalDateTime.of(2024, 10, 22, 10, 0), LocalDateTime.of(2024, 10, 22, 12, 0)),
                createSegment(LocalDateTime.of(2024, 10, 22, 14, 0), LocalDateTime.of(2024, 10, 22, 15, 0))
        ));

        // 4. Рейс с 5 сегментами (содержит ошибку между сегментами)
        flights.add(createFlight(
                createSegment(LocalDateTime.of(2024, 10, 23, 8, 0), LocalDateTime.of(2024, 10, 23, 10, 0)),
                createSegment(LocalDateTime.of(2024, 10, 23, 12, 0), LocalDateTime.of(2024, 10, 23, 15, 10)), // Ошибка между сегментами
                createSegment(LocalDateTime.of(2024, 10, 23, 15, 0), LocalDateTime.of(2024, 10, 23, 16, 0)),
                createSegment(LocalDateTime.of(2024, 10, 23, 18, 0), LocalDateTime.of(2024, 10, 23, 19, 0)),
                createSegment(LocalDateTime.of(2024, 10, 23, 21, 0), LocalDateTime.of(2024, 10, 23, 23, 0))
        ));

        // 5. Рейс с 6 сегментами (данные должны быть отфильтрованы)
        flights.add(createFlight(
                createSegment(LocalDateTime.of(2024, 10, 24, 7, 0), LocalDateTime.of(2024, 10, 24, 9, 0)),
                createSegment(LocalDateTime.of(2024, 10, 24, 10, 0), LocalDateTime.of(2024, 10, 24, 9, 30)), // Ошибка
                createSegment(LocalDateTime.of(2024, 10, 24, 11, 0), LocalDateTime.of(2024, 10, 24, 12, 0)),
                createSegment(LocalDateTime.of(2024, 10, 24, 14, 0), LocalDateTime.of(2024, 10, 24, 17, 10)), // Ошибка между следующим сегментом
                createSegment(LocalDateTime.of(2024, 10, 24, 17, 0), LocalDateTime.of(2024, 10, 24, 18, 0)),
                createSegment(LocalDateTime.of(2024, 10, 24, 20, 0), LocalDateTime.of(2024, 10, 24, 21, 0))
        ));

        // 6-10. Дополнительных рейсы, для вариативности
        flights.add(createFlight(
                createSegment(LocalDateTime.of(2024, 10, 25, 9, 0), LocalDateTime.of(2024, 10, 25, 10, 0)),
                createSegment(LocalDateTime.of(2024, 10, 25, 12, 0), LocalDateTime.of(2024, 10, 25, 13, 0))
        ));
        flights.add(createFlight(
                createSegment(LocalDateTime.of(2024, 10, 26, 10, 0), LocalDateTime.of(2024, 10, 26, 11, 0))
        ));
        flights.add(createFlight(
                createSegment(LocalDateTime.of(2024, 10, 27, 6, 0), LocalDateTime.of(2024, 10, 27, 8, 0)),
                createSegment(LocalDateTime.of(2024, 10, 27, 9, 0), LocalDateTime.of(2024, 10, 27, 11, 0)),
                createSegment(LocalDateTime.of(2024, 10, 27, 13, 0), LocalDateTime.of(2024, 10, 27, 15, 0))
        ));
        flights.add(createFlight(
                createSegment(LocalDateTime.of(2024, 10, 28, 7, 0), LocalDateTime.of(2024, 10, 28, 9, 0)),
                createSegment(LocalDateTime.of(2024, 10, 28, 11, 0), LocalDateTime.of(2024, 10, 28, 12, 0)),
                createSegment(LocalDateTime.of(2024, 10, 28, 13, 0), LocalDateTime.of(2024, 10, 28, 15, 0)),
                createSegment(LocalDateTime.of(2024, 10, 28, 17, 0), LocalDateTime.of(2024, 10, 28, 18, 0))
        ));
        flights.add(createFlight(
                createSegment(LocalDateTime.of(2024, 10, 29, 5, 0), LocalDateTime.of(2024, 10, 29, 6, 0)),
                createSegment(LocalDateTime.of(2024, 10, 29, 7, 0), LocalDateTime.of(2024, 10, 29, 8, 0)),
                createSegment(LocalDateTime.of(2024, 10, 29, 9, 0), LocalDateTime.of(2024, 10, 29, 11, 0))
        ));

        return flights;
    }

    private static Flight createFlight(Segment... segments) {
        return new Flight(Arrays.asList(segments));
    }
}

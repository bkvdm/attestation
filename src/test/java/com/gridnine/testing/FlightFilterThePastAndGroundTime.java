package com.gridnine.testing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FlightFilterThePastAndGroundTime {

    private ExcludeLongGroundTime excludeLongGroundTime;
    private List<Flight> flights;

    @BeforeEach
    public void setUp() {
        excludeLongGroundTime = new ExcludeLongGroundTime();

        // Пример сегментов, исключая рейсы с ожиданием 24 часа и более часов
        flights = Arrays.asList(
                new Flight(Arrays.asList(
                        new Segment(LocalDateTime.now().plusHours(1), LocalDateTime.now().plusHours(2)),
                        new Segment(LocalDateTime.now().plusHours(3), LocalDateTime.now().plusHours(4)) // Ожидание 1 час
                )),
                new Flight(Arrays.asList(
                        new Segment(LocalDateTime.now().plusHours(1), LocalDateTime.now().plusHours(2)),
                        new Segment(LocalDateTime.now().plusHours(5), LocalDateTime.now().plusHours(6)) // Ожидание 3 часа
                ))
        );
    }

    @ParameterizedTest
    @MethodSource("provideFlightCombinations")
    public void testFlightCombinations(Optional<Byte> hoursGround, int expectedCount) {
        // Применили фильтр с указанным временем ожидания
        List<Flight> filteredFlights = excludeLongGroundTime.apply(flights, hoursGround);

        // Проверка ожидаемого количества полётов после фильтрации
        assertEquals(expectedCount, filteredFlights.size(), "Неожидаемое тестом количество рейсов после фильтрации");
    }

    private static Stream<Arguments> provideFlightCombinations() {
        return Stream.of(
                Arguments.of(Optional.of((byte) 1), 1), // Ожидание 1 полёт (ожидание до 2 часов)
                Arguments.of(Optional.of((byte) 3), 2), // Ожидание 2 полетов (ожидание до 3 часов)
                Arguments.of(Optional.of((byte) 24), 2), // Ожидание 2 полетов (ожидание до 24 часов, не включая 24 часа)
                Arguments.of(Optional.empty(), 2) // Если фильтр не применён, ожидание 2 полетов
        );
    }
}






//    public static Stream<Arguments> timeVariationsForCase2AndCase4() {
//        return Stream.of(
//                Arguments.of(1, 22),
//                Arguments.of(2, 21),
//                Arguments.of(3, 20),
//                Arguments.of(4, 19),
//                Arguments.of(5, 18),
//                Arguments.of(6, 17),
//                Arguments.of(7, 16),
//                Arguments.of(8, 15),
//                Arguments.of(9, 14),
//                Arguments.of(10, 13),
//                Arguments.of(11, 12),
//                Arguments.of(12, 11),
//                Arguments.of(13, 10),
//                Arguments.of(14, 9),
//                Arguments.of(15, 8),
//                Arguments.of(16, 7),
//                Arguments.of(17, 6),
//                Arguments.of(18, 5),
//                Arguments.of(19, 4),
//                Arguments.of(20, 3),
//                Arguments.of(21, 2),
//                Arguments.of(22, 1),
//                Arguments.of(23, 0)
//        );
//    }
//
//    public static Stream<Arguments> timeVariationsForCase3AndCase4() {
//        return Stream.of(
//                Arguments.of(1, 0),
//                Arguments.of(2, 1),
//                Arguments.of(3, 2),
//                Arguments.of(4, 3),
//                Arguments.of(5, 4),
//                Arguments.of(6, 5),
//                Arguments.of(7, 6),
//                Arguments.of(8, 7),
//                Arguments.of(9, 8),
//                Arguments.of(10, 9),
//                Arguments.of(11, 10),
//                Arguments.of(12, 11),
//                Arguments.of(13, 12),
//                Arguments.of(14, 13),
//                Arguments.of(15, 14),
//                Arguments.of(16, 15),
//                Arguments.of(17, 16),
//                Arguments.of(18, 17),
//                Arguments.of(19, 18),
//                Arguments.of(20, 19),
//                Arguments.of(21, 20),
//                Arguments.of(22, 21),
//                Arguments.of(23, 22)
//        );
//    }
//
//    public static Stream<Arguments> timeVariationsForCase2AndCase3AndCase4() {
//        return Stream.of(
//                Arguments.of(1, 0),
//                Arguments.of(2, 1),
//                Arguments.of(3, 2),
//                Arguments.of(4, 3),
//                Arguments.of(5, 4),
//                Arguments.of(6, 5),
//                Arguments.of(7, 6),
//                Arguments.of(8, 7),
//                Arguments.of(9, 8),
//                Arguments.of(10, 9),
//                Arguments.of(11, 10),
//                Arguments.of(12, 11),
//                Arguments.of(13, 12),
//                Arguments.of(14, 13),
//                Arguments.of(15, 14),
//                Arguments.of(16, 15),
//                Arguments.of(17, 16),
//                Arguments.of(18, 17),
//                Arguments.of(19, 18),
//                Arguments.of(20, 19),
//                Arguments.of(21, 20),
//                Arguments.of(22, 21),
//                Arguments.of(23, 22)
//        );
//    }
//
//    @ParameterizedTest
//    @MethodSource("timeVariationsForCase2AndCase4")
//    public void testCase2WithCase4(int timeBetween, int expectedCount) {
////        List<Flight> filteredFlights = filterContext.filterPastDepartures(flightSegments));
////        filteredFlights = filterContext.filterLongGroundTime(filteredFlights, Optional.of((byte) timeBetween));
//        List<Segment> filteredSegments =
//        filteredSegments
//        assertEquals(expectedCount, filteredFlights.size(), "Не совпадает количество рейсов для case 2 + case 4");
//    }
//
//    @ParameterizedTest
//    @MethodSource("timeVariationsForCase3AndCase4")
//    public void testCase3WithCase4(int timeBetween, int expectedCount) {
//        List<Flight> filteredFlights = filterContext.filterArrivalBeforeDeparture(flightSegments));
//        filteredFlights = filterContext.filterLongGroundTime(filteredFlights, Optional.of((byte) timeBetween));
//        assertEquals(expectedCount, filteredFlights.size(), "Не совпадает количество рейсов для case 3 + case 4");
//    }
//
//    @ParameterizedTest
//    @MethodSource("timeVariationsForCase2AndCase3AndCase4")
//    public void testCase2WithCase3AndCase4(int timeBetween, int expectedCount) {
//        List<Flight> filteredFlights = filterContext.filterPastDepartures(flightSegments));
//        filteredFlights = filterContext.filterArrivalBeforeDeparture(filteredFlights);
//        filteredFlights = filterContext.filterLongGroundTime(filteredFlights, Optional.of((byte) timeBetween));
//        assertEquals(expectedCount, filteredFlights.size(), "Не совпадает количество рейсов для case 2 + case 3 + case 4");
//    }
//
//    @AfterEach
//    void tearDown() {
//        // Очистка после каждого теста
//    }

//    private List<Flight> convertSegmentsToFlights(List<Segment> segments) {
//        // Проверка на пустой список сегментов
//        if (segments == null || segments.isEmpty()) {
//            return Collections.emptyList(); // Возвращаем пустой список, если сегменты отсутствуют
//        }
//
//        // Создание списка рейсов
//        List<Flight> flights = new ArrayList<>();
//
//        // Перебираем сегменты и создаем рейсы
//        for (Segment segment : segments) {
//            // Создаем рейс, содержащий текущий сегмент
//            List<Segment> singleSegmentList = new ArrayList<>();
//            singleSegmentList.add(segment);
//
//            Flight flight = new Flight(singleSegmentList);
//            flights.add(flight); // Добавляем рейс в список
//        }
//
//        return flights; // Возвращаем список рейсов
//    }





//import org.junit.jupiter.api.BeforeEach;
//
//import java.time.LocalDateTime;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Stream;
//
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.Arguments;
//import org.junit.jupiter.params.provider.MethodSource;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class FlightFilterTest {
//
//    private FlightFilterContext filterContext;
//    private List<Segment> flightSegments;
//
//    @BeforeEach
//    public void setUp() {
//        filterContext = new FlightFilterContext();
//        filterContext.addGroundTimeRule(new ExcludeLongGroundTime());
//
//        flightSegments = Arrays.asList(
//                new Segment(LocalDateTime.now().plusHours(1), LocalDateTime.now().plusHours(2)),   // Ожидание 1 час
//                new Segment(LocalDateTime.now().plusHours(2), LocalDateTime.now().plusHours(4)),   // Ожидание 2 часа
//                new Segment(LocalDateTime.now().plusHours(3), LocalDateTime.now().plusHours(6)),   // Ожидание 3 часа
//                new Segment(LocalDateTime.now().plusHours(4), LocalDateTime.now().plusHours(8)),   // Ожидание 4 часа
//                new Segment(LocalDateTime.now().plusHours(5), LocalDateTime.now().plusHours(10)),  // Ожидание 5 часов
//                new Segment(LocalDateTime.now().plusHours(6), LocalDateTime.now().plusHours(12)),  // Ожидание 6 часов
//                new Segment(LocalDateTime.now().plusHours(7), LocalDateTime.now().plusHours(14)),  // Ожидание 7 часов
//                new Segment(LocalDateTime.now().plusHours(8), LocalDateTime.now().plusHours(16)),  // Ожидание 8 часов
//                new Segment(LocalDateTime.now().plusHours(9), LocalDateTime.now().plusHours(18)),  // Ожидание 9 часов
//                new Segment(LocalDateTime.now().plusHours(10), LocalDateTime.now().plusHours(20)), // Ожидание 10 часов
//                new Segment(LocalDateTime.now().plusHours(11), LocalDateTime.now().plusHours(22)), // Ожидание 11 часов
//                new Segment(LocalDateTime.now().plusHours(12), LocalDateTime.now().plusHours(23)), // Ожидание 12 часов
//                new Segment(LocalDateTime.now().plusHours(13), LocalDateTime.now().plusHours(25)), // Ожидание 13 часов
//                new Segment(LocalDateTime.now().plusHours(14), LocalDateTime.now().plusHours(26)), // Ожидание 14 часов
//                new Segment(LocalDateTime.now().plusHours(15), LocalDateTime.now().plusHours(27)), // Ожидание 15 часов
//                new Segment(LocalDateTime.now().plusHours(16), LocalDateTime.now().plusHours(28)), // Ожидание 16 часов
//                new Segment(LocalDateTime.now().plusHours(17), LocalDateTime.now().plusHours(29)), // Ожидание 17 часов
//                new Segment(LocalDateTime.now().plusHours(18), LocalDateTime.now().plusHours(30)), // Ожидание 18 часов
//                new Segment(LocalDateTime.now().plusHours(19), LocalDateTime.now().plusHours(31)), // Ожидание 19 часов
//                new Segment(LocalDateTime.now().plusHours(20), LocalDateTime.now().plusHours(32)), // Ожидание 20 часов
//                new Segment(LocalDateTime.now().plusHours(21), LocalDateTime.now().plusHours(33)), // Ожидание 21 час
//                new Segment(LocalDateTime.now().plusHours(22), LocalDateTime.now().plusHours(34)), // Ожидание 22 часа
//                new Segment(LocalDateTime.now().plusHours(23), LocalDateTime.now().plusHours(35))  // Ожидание 23 часа
//        );
//    }
//
//    public static Stream<Arguments> timeVariationsForCase2AndCase4() {
//        return Stream.of(
//                // Для комбинаций фильтров: case 2 + case 4
//                Arguments.of(1, 22),
//                Arguments.of(2, 21),
//                Arguments.of(3, 20),
//                Arguments.of(4, 19),
//                Arguments.of(5, 18),
//                Arguments.of(6, 17),
//                Arguments.of(7, 16),
//                Arguments.of(8, 15),
//                Arguments.of(9, 14),
//                Arguments.of(10, 13),
//                Arguments.of(11, 12),
//                Arguments.of(12, 11),
//                Arguments.of(13, 10),
//                Arguments.of(14, 9),
//                Arguments.of(15, 8),
//                Arguments.of(16, 7),
//                Arguments.of(17, 6),
//                Arguments.of(18, 5),
//                Arguments.of(19, 4),
//                Arguments.of(20, 3),
//                Arguments.of(21, 2),
//                Arguments.of(22, 1),
//                Arguments.of(23, 0)
//        );
//    }
//
//    public static Stream<Arguments> timeVariationsForCase3AndCase4() {
//        return Stream.of(
//
//                // Для комбинаций фильтров: case 3 + case 4
//                Arguments.of(1, 0),
//                Arguments.of(2, 1),
//                Arguments.of(3, 2),
//                Arguments.of(4, 3),
//                Arguments.of(5, 4),
//                Arguments.of(6, 5),
//                Arguments.of(7, 6),
//                Arguments.of(8, 7),
//                Arguments.of(9, 8),
//                Arguments.of(10, 9),
//                Arguments.of(11, 10),
//                Arguments.of(12, 11),
//                Arguments.of(13, 12),
//                Arguments.of(14, 13),
//                Arguments.of(15, 14),
//                Arguments.of(16, 15),
//                Arguments.of(17, 16),
//                Arguments.of(18, 17),
//                Arguments.of(19, 18),
//                Arguments.of(20, 19),
//                Arguments.of(21, 20),
//                Arguments.of(22, 21),
//                Arguments.of(23, 22)
//
//        );
//    }
//
//    public static Stream<Arguments> timeVariationsForCase2AndCase3AndCase4() {
//        return Stream.of(
//                // Для комбинаций фильтров: case 2 + case 3 + case 4
//                Arguments.of(1, 0),
//                Arguments.of(2, 1),
//                Arguments.of(3, 2),
//                Arguments.of(4, 3),
//                Arguments.of(5, 4),
//                Arguments.of(6, 5),
//                Arguments.of(7, 6),
//                Arguments.of(8, 7),
//                Arguments.of(9, 8),
//                Arguments.of(10, 9),
//                Arguments.of(11, 10),
//                Arguments.of(12, 11),
//                Arguments.of(13, 12),
//                Arguments.of(14, 13),
//                Arguments.of(15, 14),
//                Arguments.of(16, 15),
//                Arguments.of(17, 16),
//                Arguments.of(18, 17),
//                Arguments.of(19, 18),
//                Arguments.of(20, 19),
//                Arguments.of(21, 20),
//                Arguments.of(22, 21),
//                Arguments.of(23, 22)
//        );
//    }
//
//    @ParameterizedTest
//    @MethodSource("timeVariationsForCase2AndCase4")
//    public void testCase2WithCase4(int from, int to, int expectedCount) {
//        List<Flight> filteredFlights = filterContext.filterPastDepartures(flightSegments);
//        filteredFlights = filterContext.filterLongGroundTime(filteredFlights, Optional.of((byte) to));
//        assertEquals(expectedCount, filteredFlights.size(), "Не совпадает количество рейсов для case 2 + case 4");
//    }
//
//    @ParameterizedTest
//    @MethodSource("timeVariationsForCase3AndCase4")
//    public void testCase3WithCase4(int from, int to, int expectedCount) {
//        List<Flight> filteredFlights = filterContext.filterArrivalBeforeDeparture(flightSegments);
//        filteredFlights = filterContext.filterLongGroundTime(filteredFlights, Optional.of((byte) to));
//        assertEquals(expectedCount, filteredFlights.size(), "Не совпадает количество рейсов для case 3 + case 4");
//    }
//
//    @ParameterizedTest
//    @MethodSource("timeVariationsForCase2AndCase3AndCase4")
//    public void testCase2WithCase3AndCase4(int from, int to, int expectedCount) {
//        List<Flight> filteredFlights = filterContext.filterPastDepartures(flightSegments);
//        filteredFlights = filterContext.filterArrivalBeforeDeparture(filteredFlights);
//        filteredFlights = filterContext.filterLongGroundTime(filteredFlights, Optional.of((byte) to));
//        assertEquals(expectedCount, filteredFlights.size(), "Не совпадает количество рейсов для case 2 + case 3 + case 4");
//    }
//
//
//    @org.junit.jupiter.api.AfterEach
//    void tearDown() {
//    }
//}
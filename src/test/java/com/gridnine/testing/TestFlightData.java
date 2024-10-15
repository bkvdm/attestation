package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class TestFlightData {
    public static List<Flight> createTestFlights() {
        // Сегменты, где все прибытия позже вылетов
        Segment validSegment1 = new Segment(LocalDateTime.of(2024, 10, 15, 21, 0), LocalDateTime.of(2024, 10, 15, 23, 0)); // 2 часа ожидания
        Segment validSegment2 = new Segment(LocalDateTime.of(2024, 10, 15, 23, 0), LocalDateTime.of(2024, 10, 16, 1, 0)); // 1 час ожидания

        // Сегменты с ошибками (прибытие раньше вылета)
        Segment invalidSegment1 = new Segment(LocalDateTime.of(2024, 10, 15, 21, 0), LocalDateTime.of(2024, 10, 15, 20, 0)); // Прибытие раньше вылета
        Segment invalidSegment2 = new Segment(LocalDateTime.of(2024, 10, 15, 23, 30), LocalDateTime.of(2024, 10, 15, 22, 0)); // Прибытие раньше вылета

        // Сегменты с допустимым временем ожидания на земле
        Segment longWaitSegment1 = new Segment(LocalDateTime.of(2024, 10, 15, 21, 0), LocalDateTime.of(2024, 10, 15, 22, 0)); // 1 час ожидания
        Segment longWaitSegment2 = new Segment(LocalDateTime.of(2024, 10, 15, 22, 0), LocalDateTime.of(2024, 10, 15, 23, 0)); // 1 час ожидания
        Segment longWaitSegment3 = new Segment(LocalDateTime.of(2024, 10, 15, 23, 0), LocalDateTime.of(2024, 10, 16, 0, 0)); // 1 час ожидания

        // Рейсы с различными комбинациями сегментов
        Flight flight1 = new Flight(Arrays.asList(validSegment1, validSegment2)); // Ожидается, что пройдет оба фильтра
        Flight flight2 = new Flight(Arrays.asList(invalidSegment1, validSegment1)); // Ожидается, что будет исключен по времени прибытия
        Flight flight3 = new Flight(Arrays.asList(longWaitSegment1, longWaitSegment2)); // Ожидается, что пройдет оба фильтра
        Flight flight4 = new Flight(Arrays.asList(longWaitSegment2, longWaitSegment3)); // Ожидается, что пройдет оба фильтра
        Flight flight5 = new Flight(Arrays.asList(invalidSegment2, longWaitSegment1)); // Ожидается, что будет исключен по времени прибытия

        return Arrays.asList(flight1, flight2, flight3, flight4, flight5);
    }
}








//public class TestFlightData {
//
//    public static List<Flight> createTestFlights() {
//        // Создаем различные сегменты с различным временем вылета и прибытия
//
//        // Сегменты, где все прибытия позже вылетов
//        Segment validSegment1 = new Segment(LocalDateTime.of(2024, 10, 15, 21, 0), LocalDateTime.of(2024, 10, 15, 23, 0));
//        Segment validSegment2 = new Segment(LocalDateTime.of(2024, 10, 15, 23, 30), LocalDateTime.of(2024, 10, 16, 0, 30));
//
//        // Сегменты с ошибками (прибытие раньше вылета)
//        Segment invalidSegment1 = new Segment(LocalDateTime.of(2024, 10, 15, 21, 0), LocalDateTime.of(2024, 10, 15, 20, 0));
//        Segment invalidSegment2 = new Segment(LocalDateTime.of(2024, 10, 15, 23, 30), LocalDateTime.of(2024, 10, 15, 22, 0));
//
//        // Сегменты с длительным ожиданием на земле
//        Segment longWaitSegment1 = new Segment(LocalDateTime.of(2024, 10, 15, 21, 0), LocalDateTime.of(2024, 10, 15, 22, 0));
//        Segment longWaitSegment2 = new Segment(LocalDateTime.of(2024, 10, 15, 22, 30), LocalDateTime.of(2024, 10, 16, 0, 0)); // Ожидание 30 минут (корректно)
//        Segment longWaitSegment3 = new Segment(LocalDateTime.of(2024, 10, 15, 22, 0), LocalDateTime.of(2024, 10, 16, 1, 0)); // Ожидание 1 часа (корректно)
//        Segment longWaitSegment4 = new Segment(LocalDateTime.of(2024, 10, 15, 22, 0), LocalDateTime.of(2024, 10, 16, 2, 0)); // Ожидание 2 часов (корректно)
//        Segment longWaitSegment5 = new Segment(LocalDateTime.of(2024, 10, 15, 21, 0), LocalDateTime.of(2024, 10, 16, 22, 0)); // Ожидание 24 часа (некорректно)
//
//        // Рейсы с различными комбинациями сегментов
//        Flight flight1 = new Flight(Arrays.asList(validSegment1, validSegment2)); // Ожидается, что пройдет оба фильтра
//        Flight flight2 = new Flight(Arrays.asList(invalidSegment1, validSegment1)); // Ожидается, что будет исключен по времени прибытия
//        Flight flight3 = new Flight(Arrays.asList(validSegment1, longWaitSegment1, longWaitSegment2)); // Ожидается, что пройдет, так как нет ожидания >= 24 часа
//        Flight flight4 = new Flight(Arrays.asList(longWaitSegment4, longWaitSegment5)); // Ожидается, что будет исключен по ожиданию на земле
//        Flight flight5 = new Flight(Arrays.asList(invalidSegment2, longWaitSegment1)); // Ожидается, что будет исключен по времени прибытия
//
//        return Arrays.asList(flight1, flight2, flight3, flight4, flight5);
//    }
//}


package com.gridnine.testing;

import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class FlightFilterThePastAndGroundTime {

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
                )),
                new Flight(Arrays.asList(
                        new Segment(LocalDateTime.now().plusHours(1), LocalDateTime.now().plusHours(3)),
                        new Segment(LocalDateTime.now().plusHours(4), LocalDateTime.now().plusHours(5)) // Ожидание 1 час
                )),
                new Flight(Arrays.asList(
                        new Segment(LocalDateTime.now().plusHours(1), LocalDateTime.now().plusHours(2)),
                        new Segment(LocalDateTime.now().plusHours(24), LocalDateTime.now().plusHours(25)) // Ожидание 22 часа
                ))
        );
    }

    @Test
    public void testFilterFlights() {
        // Применение фильтра с фиксированным временем ожидания (2 часа)
        List<Flight> filteredFlights = excludeLongGroundTime.apply(flights);

        // Ожидание, что после фильтра останется 2 рейса (первый и третий)
        assertEquals(2, filteredFlights.size(), "Неожидаемое количество рейсов после фильтрации");
    }
}

package com.gridnine.testing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExcludeDeparturesInThePastTest {

    private ExcludeDeparturesInThePast excludeDeparturesInThePast;

    @BeforeEach
    public void setUp() {
        excludeDeparturesInThePast = new ExcludeDeparturesInThePast();
    }

    @Test
    public void testExcludeDeparturesInThePast() {
        // Данные для тестов фильтра, исключающий рейсы с вылетом, которые состоялись в прошлом
        List<Flight> flights = Arrays.asList(
                // Рейс с вылетом в будущем
                new Flight(Arrays.asList(
                        new Segment(LocalDateTime.now().plusHours(2), LocalDateTime.now().plusHours(3)),
                        new Segment(LocalDateTime.now().plusHours(4), LocalDateTime.now().plusHours(5))
                )),
                // Рейс с вылетом в прошлом
                new Flight(Arrays.asList(
                        new Segment(LocalDateTime.now().minusHours(1), LocalDateTime.now().plusHours(1)),
                        new Segment(LocalDateTime.now().plusHours(2), LocalDateTime.now().plusHours(3))
                )),
                // Рейс с вылетами в прошлом
                new Flight(Arrays.asList(
                        new Segment(LocalDateTime.now().minusHours(2), LocalDateTime.now().minusHours(1)),
                        new Segment(LocalDateTime.now().minusHours(1), LocalDateTime.now())
                )),
                // Рейс с вылетами в будущем
                new Flight(Arrays.asList(
                        new Segment(LocalDateTime.now().plusHours(1), LocalDateTime.now().plusHours(2)),
                        new Segment(LocalDateTime.now().plusHours(3), LocalDateTime.now().plusHours(4))
                ))
        );

        // Примение фильтра
        List<Flight> filteredFlights = excludeDeparturesInThePast.apply(flights);

        // Ожидание, что будет 2 рейса в списке рейсов после этой фильтрации
        assertEquals(2, filteredFlights.size(), "Количество рейсов после фильтрации должно быть 2");
    }
}

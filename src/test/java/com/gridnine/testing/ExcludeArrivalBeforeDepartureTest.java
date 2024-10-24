package com.gridnine.testing;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class ExcludeArrivalBeforeDepartureTest {

    private final ExcludeArrivalBeforeDeparture filter = new ExcludeArrivalBeforeDeparture();

    @Test
    public void testExcludeArrivalBeforeDeparture() {
        List<Flight> flights = TestFlightData.createTestFlightsForArrivalBeforeDeparture();

        // Применение фильтра для исключения рейсов с некорректными сегментами
        List<Flight> filteredFlights = filter.apply(flights);

        // Проверка количества рейсов после фильтрации
        assertEquals(7, filteredFlights.size(), "Ожидается 7 рейсов после фильтрации");

        // Проверяем, исключенных из списка рейсов
        assertFalse(filteredFlights.contains(flights.get(0)), "Рейс flight1 должен быть исключён.");
        assertFalse(filteredFlights.contains(flights.get(2)), "Рейс flight3 должен быть исключён.");
        assertFalse(filteredFlights.contains(flights.get(4)), "Рейс flight5 должен быть исключён.");
    }
}

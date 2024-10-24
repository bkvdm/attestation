package com.gridnine.testing;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ExcludeLongGroundTimeTest {

    @Test
    public void testExcludeLongGroundTime() {
        ExcludeLongGroundTime filter = new ExcludeLongGroundTime();
        List<Flight> flights = TestFlightData.createTestFlights();

        // Применение фильтра с фиксированным временем ожидания (2 часа)
        List<Flight> filteredFlights = filter.apply(flights);

        // Выводим количество рейсов для отладки
        System.out.println("Общее количество рейсов: " + flights.size());
        System.out.println("Количество отфильтрованных рейсов: " + filteredFlights.size());

        // Ожидается, что отфильтрованный список будет содержать 15 рейсов
        assertEquals(24, filteredFlights.size(), "Количество рейсов после фильтрации должно быть 24");

        // Проверяем, что исключены рейсы с превышающим временем ожидания
        assertFalse(filteredFlights.contains(flights.get(4)), "Рейс flight5 должен быть исключен.");
        assertFalse(filteredFlights.contains(flights.get(5)), "Рейс flight6 должен быть исключен.");
        assertFalse(filteredFlights.contains(flights.get(6)), "Рейс flight7 должен быть исключен.");
        assertFalse(filteredFlights.contains(flights.get(8)), "Рейс flight9 должен быть исключен.");
        assertFalse(filteredFlights.contains(flights.get(9)), "Рейс flight10 должен быть исключен.");
        assertFalse(filteredFlights.contains(flights.get(11)), "Рейс flight12 должен быть исключен.");
    }
}

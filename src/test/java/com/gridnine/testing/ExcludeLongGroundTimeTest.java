package com.gridnine.testing;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExcludeLongGroundTimeTest {

    @Test
    public void testExcludeLongGroundTime() {
        ExcludeLongGroundTime filter = new ExcludeLongGroundTime();
        List<Flight> flights = TestFlightData.createTestFlights();

        // Установка максимального времени ожидания на земле (для примера, 2 часа)
        Optional<Byte> hoursGroundOptional = Optional.of((byte) 2);

        List<Flight> filteredFlights = filter.apply(flights, hoursGroundOptional);

        // Ожидание, что отфильтрованный список будет содержать 1 рейс
        assertEquals(1, filteredFlights.size(), "Количество рейсов после фильтрации должно быть 1");
    }
}

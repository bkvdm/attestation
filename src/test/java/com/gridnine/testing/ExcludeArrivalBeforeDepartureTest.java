package com.gridnine.testing;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExcludeArrivalBeforeDepartureTest {

    private final ExcludeArrivalBeforeDeparture filter = new ExcludeArrivalBeforeDeparture();

    @Test
    public void testExcludeArrivalBeforeDeparture() {
        List<Flight> flights = TestFlightData.createTestFlights();

        // Проверка количества рейсов после применения фильтра
        assertEquals(3, filter.apply(flights).size(), "Expected 3 flights after filtering");
    }
}

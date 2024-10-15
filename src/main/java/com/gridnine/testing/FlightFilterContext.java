package com.gridnine.testing;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Конструктор условий фильтров рейсов.
 * Этот класс позволяет добавлять правила фильтрации, а затем последовательно применять их к списку рейсов.
 */
public class FlightFilterContext {

    // Список правил фильтров, которые будут применены к рейсам
    private final List<ExcludeDeparturesInThePast> pastRules = new ArrayList<>();
    private final List<ExcludeArrivalBeforeDeparture> arrivalRules = new ArrayList<>();
    private final List<ExcludeLongGroundTime> groundTimeRules = new ArrayList<>();

    /**
     * Добавляет новое правило фильтрации для исключения рейсов с вылетом в прошлом.
     * @param rule правило фильтрации, реализующее интерфейс ExcludeDeparturesInThePastRule
     */
    public void addPastRule(ExcludeDeparturesInThePast rule) {
        pastRules.add(rule);
    }

    /**
     * Добавляет новое правило фильтрации для исключения рейсов, у которых прибытие происходит раньше вылета.
     * @param rule правило фильтрации, реализующее интерфейс ExcludeArrivalBeforeDepartureRule
     */
    public void addArrivalRule(ExcludeArrivalBeforeDeparture rule) {
        arrivalRules.add(rule);
    }

    /**
     * Добавляет новое правило фильтрации для исключения рейсов с долгим ожиданием на земле.
     * @param rule правило фильтрации, реализующее интерфейс ExcludeLongGroundTimeRule
     */
    public void addGroundTimeRule(ExcludeLongGroundTime rule) {
        groundTimeRules.add(rule);
    }

    /**
     * Применяет все добавленные правила фильтрации для исключения рейсов с вылетом в прошлом.
     * @param flights список исходных рейсов для фильтрации
     * @return список рейсов после применения всех фильтров
     */
    public List<Flight> filterPastDepartures(List<Flight> flights) {
        List<Flight> filteredFlights = flights;

        // Последовательное применение всех правил фильтрации
        for (ExcludeDeparturesInThePast rule : pastRules) {
            filteredFlights = rule.apply(filteredFlights); // Применяем метод apply к списку рейсов
        }
        return filteredFlights; // Возвращаем отфильтрованный список
    }

    /**
     * Применяет все добавленные правила фильтрации для исключения рейсов, у которых прибытие раньше вылета.
     * @param flights список исходных рейсов
     * @return список рейсов без тех, у которых прибытие раньше вылета
     */
    public List<Flight> filterArrivalBeforeDeparture(List<Flight> flights) {
        List<Flight> filteredFlights = flights;

        // Последовательное применение всех правил исключения, если прибытия раньше вылета
        for (ExcludeArrivalBeforeDeparture rule : arrivalRules) {
            filteredFlights = rule.apply(filteredFlights); // Применение метода apply к списку рейсов
        }
        return filteredFlights;
    }

    /**
     * Применяет все добавленные правила фильтрации для исключения рейсов с долгим ожиданием на земле.
     * @param flights список исходных рейсов
     * @param hoursGround максимально допустимое время ожидания между сегментами (в часах)
     * @return список рейсов без тех, где время на земле превышает допустимое значение
     */
    public List<Flight> filterLongGroundTime(List<Flight> flights, Optional<Byte> hoursGround) {
        List<Flight> filteredFlights = flights;

        for (ExcludeLongGroundTime rule : groundTimeRules) {
            filteredFlights = rule.apply(filteredFlights, hoursGround); // Применение метода apply к списку рейсов
        }
        return filteredFlights;
    }

    /**
     * Возвращает список всех рейсов без применения фильтров (если метод вызван напрямую).
     * @return список всех доступных рейсов
     */
    public List<Flight> getAllFlights() {
        return FlightBuilder.createFlights(); // Возвращаем все рейсы
    }
}

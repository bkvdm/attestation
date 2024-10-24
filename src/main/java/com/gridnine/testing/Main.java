package com.gridnine.testing;

import java.util.*;

import java.util.List;
import java.util.Scanner;

/**
 * Главный класс приложения для фильтрации рейсов.
 *
 * <p>Этот класс предоставляет возможность фильтрации рейсов через текстовый интерфейс.
 * Можно выбирать различные фильтры для отображения рейсов, основываясь на различных условиях, таких как
 * вылеты в прошлом, прибытие до вылета и время ожидания на земле, то есть комбинации фильтров.</p>
 *
 * <p>В классе используется {@link Scanner} для считывания пользовательского ввода
 * и класс {@link FlightFilterContext} для применения фильтров к списку рейсов.</p>
 *
 * <p>Доступные фильтры:</p>
 * <ol>
 *     <li>Получить информацию о всех рейсах без фильтров.</li>
 *     <li>Исключить рейсы с вылетом в прошлом.</li>
 *     <li>Исключить рейсы, у которых время прибытия раньше времени вылета.</li>
 *     <li>Исключить рейсы с общим временем ожидания на земле, превышающим заданное значение.</li>
 *     <li>Применить все указанные фильтры и отобразить отфильтрованные рейсы.</li>
 *     <li>Выход из программы.</li>
 * </ol>
 *
 * <p>Программа не прервёт работу пока пользователь не решит выйти, выбрав 0 в консоль.</p>
 *
 * @author Вадим Бикбулатов www.bvm.tel
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FlightFilterContext filterContext = new FlightFilterContext();

        // Добавление условия фильтрации
        filterContext.addGroundTimeRule(new ExcludeLongGroundTime());

        // Объявление переменной за границами switch
        Optional<Byte> hoursGroundOpt = Optional.empty();

        while (true) {
            System.out.println("Выберите фильтр:");
            System.out.println("1. Получить информацию о всех рейсах, без фильтров");
            System.out.println("2. Применить фильтр для вылетов в прошлом. (Вылет до текущего момента времени.)");
            System.out.println("3. Применить фильтр для рейсов: прибытия до вылета. (Сегменты с датой прилёта раньше даты вылета.)");
            System.out.println("4. Применить фильтр для рейсов времени ожидания. (Перелеты, где общее время, проведённое на земле, превышает количество часов переданное пользователем.)");
            System.out.println("5. Применить все фильтры и получить результат (не требует запуска после 4 пункта)");
            System.out.println("0. Выход");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    List<Flight> flights = filterContext.getAllFlights(); // Получение всех рейсов
                    if (flights.isEmpty()) {
                        System.out.println("Нет доступных рейсов.");
                    } else {
                        for (Flight flight : flights) {
                            System.out.println(flight); // Вывод каждого рейса с новой строки
                        }
                    }
                    break;

                case 2:
                    filterContext.addPastRule(new ExcludeDeparturesInThePast());
                    System.out.println("Фильтр для исключения рейсов с вылетом в прошлом добавлен.");
                    break;

                case 3:
                    filterContext.addArrivalRule(new ExcludeArrivalBeforeDeparture());
                    System.out.println("Фильтр для исключения рейсов, у которых прибытие раньше вылета, добавлен.");
                    break;

                case 4:
                    try {
                        // Применение фильтра времени ожидания (фиксировано 2 часа)
                        List<Flight> filteredByGroundTime = filterContext.filterLongGroundTime(filterContext.getAllFlights());
                        System.out.println("Отфильтрованные рейсы по времени ожидания (больше 2 часов):");
                        filteredByGroundTime.forEach(System.out::println); // Вывод каждого рейса на отдельной строке
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage()); // Вывод сообщения об ошибке
                    }
                    break;

                case 5:
                    List<Flight> flightsToFilter = filterContext.getAllFlights();

                    // Применение фильтра по прошлым вылетам, если был выбран
                    flightsToFilter = filterContext.filterPastDepartures(flightsToFilter);

                    // Применение фильтра по прибытиям раньше вылетов, если был выбран
                    flightsToFilter = filterContext.filterArrivalBeforeDeparture(flightsToFilter);

                    // Применение фильтра времени ожидания на земле (фиксировано 2 часа)
                    flightsToFilter = filterContext.filterLongGroundTime(flightsToFilter);

                    // Вывод отфильтрованных рейсов
                    System.out.println("Отфильтрованные рейсы:");
                    flightsToFilter.forEach(System.out::println);
                    break;

                case 0:
                    System.out.println("Выход из программы.");
                    return;

                default:
                    System.out.println("Неверный выбор. Попробуйте еще раз.");
            }
        }
    }
}

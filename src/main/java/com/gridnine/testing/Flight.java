package com.gridnine.testing;

import java.util.List;

/**
 * Класс полётов
 */
public class Flight {
    private final List<Segment> segments;

    Flight(final List<Segment> segs) {
        segments = segs;
    }

    List<Segment> getSegments() {
        return segments;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Рейс:\n");
        for (Segment segment : segments) {
            result.append(segment.toString()).append("\n"); // Вызов toString() для каждого сегмента
        }
        return result.toString().trim(); // Чтобы убрать лишние пробелы в конце строки
    }
}

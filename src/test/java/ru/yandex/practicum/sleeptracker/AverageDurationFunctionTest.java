package ru.yandex.practicum.sleeptracker;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AverageDurationFunctionTest {

    @Test
    void averageDuration_shouldReturnAverageSession() {

        List<SleepingSession> sessions = List.of(
                new SleepingSession(
                        LocalDateTime.of(2025, 10, 1, 22, 15),
                        LocalDateTime.of(2025, 10, 2, 8, 0),
                        SleepQuality.GOOD),
                new SleepingSession(
                        LocalDateTime.of(2025, 10, 2, 23, 0),
                        LocalDateTime.of(2025, 10, 3, 8, 0),
                        SleepQuality.NORMAL),
                new SleepingSession(
                        LocalDateTime.of(2025, 10, 3, 14, 30),
                        LocalDateTime.of(2025, 10, 3, 15, 20),
                        SleepQuality.NORMAL),
                new SleepingSession(
                        LocalDateTime.of(2025, 10, 3, 23, 30),
                        LocalDateTime.of(2025, 10, 4, 6, 20),
                        SleepQuality.BAD)
        );

        AverageDurationFunction function = new AverageDurationFunction();
        SleepAnalysisResult result = function.apply(sessions);

        assertEquals("396", result.getValue());
    }


    @Test
    void averageDuration_shouldReturnZeroForEmptyList() {

        List<SleepingSession> sessions = List.of();

        AverageDurationFunction function = new AverageDurationFunction();
        SleepAnalysisResult result = function.apply(sessions);

        assertEquals("0", result.getValue());
    }
}

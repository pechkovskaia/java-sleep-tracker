package ru.yandex.practicum.sleeptracker;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

    class MaxDurationFunctionTest {

        @Test
        void maxDuration_shouldReturnShortestSession() {

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

            MaxDurationFunction function = new MaxDurationFunction();
            SleepAnalysisResult result = function.apply(sessions);

            assertEquals("585", result.getValue());
        }

        @Test
        void maxDuration_shouldReturnZeroForEmptyList() {

            List<SleepingSession> sessions = List.of();

            MaxDurationFunction function = new MaxDurationFunction();
            SleepAnalysisResult result = function.apply(sessions);

            assertEquals("0", result.getValue());
        }
    }


package ru.yandex.practicum.sleeptracker;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NoSleepFunctionTest {

    @Test
    void noSleep_shouldReturnZeroWhenEveryNightHasSleep() {
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
                        LocalDateTime.of(2025, 10, 3, 23, 30),
                        LocalDateTime.of(2025, 10, 4, 6, 20),
                        SleepQuality.BAD)
        );

        NoSleepFunction function = new NoSleepFunction();
        SleepAnalysisResult result = function.apply(sessions);

        assertEquals("0", result.getValue());
    }

    @Test
    void noSleepShouldReturnOneNightWithNoSleep() {
        List<SleepingSession> sessions = List.of(
                new SleepingSession(
                        LocalDateTime.of(2025, 10, 1, 22, 15),
                        LocalDateTime.of(2025, 10, 2, 8, 0),
                        SleepQuality.GOOD),
                new SleepingSession(
                        LocalDateTime.of(2025, 10, 3, 23, 30),
                        LocalDateTime.of(2025, 10, 4, 6, 20),
                        SleepQuality.BAD)
        );

        NoSleepFunction function = new NoSleepFunction();
        SleepAnalysisResult result = function.apply(sessions);

        assertEquals("1", result.getValue());
    }

    @Test
    void noSleep_shouldReturnTwoNightsWithoutSleep() {

        List<SleepingSession> sessions = List.of(
                new SleepingSession(
                        LocalDateTime.of(2025, 10, 1, 22, 15),
                        LocalDateTime.of(2025, 10, 2, 8, 0),
                        SleepQuality.GOOD),

                new SleepingSession(
                        LocalDateTime.of(2025, 10, 4, 23, 30),
                        LocalDateTime.of(2025, 10, 5, 6, 20),
                        SleepQuality.BAD)
        );

        NoSleepFunction function = new NoSleepFunction();
        SleepAnalysisResult result = function.apply(sessions);

        assertEquals("2", result.getValue());
    }

    @Test
    void noSleep_shouldCountSleepAfterMidnightAsNightSleep() {

        List<SleepingSession> sessions = List.of(
                new SleepingSession(
                        LocalDateTime.of(2025, 10, 2, 2, 0),
                        LocalDateTime.of(2025, 10, 2, 5, 0),
                        SleepQuality.NORMAL)
        );

        NoSleepFunction function = new NoSleepFunction();
        SleepAnalysisResult result = function.apply(sessions);

        assertEquals("0", result.getValue());
    }
}


package ru.yandex.practicum.sleeptracker;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChronotypeFunctionTest {

        @Test
        void Chronotypes_ShouldReturnOwl() {

            List<SleepingSession> sessions = List.of(
                    new SleepingSession(
                            LocalDateTime.of(2025, 10, 1, 23, 15),
                            LocalDateTime.of(2025, 10, 2, 10, 30),
                            SleepQuality.GOOD),
                    new SleepingSession(
                            LocalDateTime.of(2025, 10, 2, 23, 0),
                            LocalDateTime.of(2025, 10, 3, 11, 0),
                            SleepQuality.NORMAL),
                    new SleepingSession(
                            LocalDateTime.of(2025, 10, 3, 14, 30),
                            LocalDateTime.of(2025, 10, 3, 15, 20),
                            SleepQuality.NORMAL),
                    new SleepingSession(
                            LocalDateTime.of(2025, 10, 3, 23, 30),
                            LocalDateTime.of(2025, 10, 4, 10, 55),
                            SleepQuality.BAD)
            );

            ChronotypeFunction function = new ChronotypeFunction();
            SleepAnalysisResult result = function.apply(sessions);
            assertEquals("OWL", result.getValue());
        }

        @Test
            void Chronotypes_ShouldReturnLark() {

                List<SleepingSession> sessions = List.of(
                        new SleepingSession(
                                LocalDateTime.of(2025, 10, 1, 21, 15),
                                LocalDateTime.of(2025, 10, 2, 6, 30),
                                SleepQuality.GOOD),
                        new SleepingSession(
                                LocalDateTime.of(2025, 10, 2, 20, 0),
                                LocalDateTime.of(2025, 10, 3, 5, 30),
                                SleepQuality.NORMAL),
                        new SleepingSession(
                                LocalDateTime.of(2025, 10, 3, 13, 30),
                                LocalDateTime.of(2025, 10, 3, 15, 20),
                                SleepQuality.NORMAL),
                        new SleepingSession(
                                LocalDateTime.of(2025, 10, 3, 21, 30),
                                LocalDateTime.of(2025, 10, 4, 6, 55),
                                SleepQuality.BAD)
                );

                ChronotypeFunction function = new ChronotypeFunction();
                SleepAnalysisResult result = function.apply(sessions);
                assertEquals("LARK", result.getValue());
            }

        @Test
            void Chronotypes_ShouldReturnPigeon() {

                List<SleepingSession> sessions = List.of(
                        new SleepingSession(
                                LocalDateTime.of(2025, 10, 1, 22, 15),
                                LocalDateTime.of(2025, 10, 2, 10, 30),
                                SleepQuality.GOOD),
                        new SleepingSession(
                                LocalDateTime.of(2025, 10, 2, 23, 0),
                                LocalDateTime.of(2025, 10, 3, 11, 0),
                                SleepQuality.NORMAL),
                        new SleepingSession(
                                LocalDateTime.of(2025, 10, 3, 14, 30),
                                LocalDateTime.of(2025, 10, 3, 15, 20),
                                SleepQuality.NORMAL),
                        new SleepingSession(
                                LocalDateTime.of(2025, 10, 3, 22, 30),
                                LocalDateTime.of(2025, 10, 4, 10, 55),
                                SleepQuality.BAD)
                );

                ChronotypeFunction function = new ChronotypeFunction();
                SleepAnalysisResult result = function.apply(sessions);
                assertEquals("PIGEON", result.getValue());
            }
        }

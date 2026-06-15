package ru.yandex.practicum.sleeptracker;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

import static java.lang.String.valueOf;

public class AverageDurationFunction implements Function<List<SleepingSession>, SleepAnalysisResult> {

    @Override public SleepAnalysisResult apply(List<SleepingSession> sessions) {
        long average = (long) sessions.stream()
                .filter(session -> session.getFallAsleepTime() != null &&
                        session.getWakeUpTime() != null)
                .mapToLong(session -> Duration.between(session.getFallAsleepTime(),
                        session.getWakeUpTime()).toMinutes())
                .average()
                .orElse(0);

        return new SleepAnalysisResult("Средняя продолжительность сессии (мин)", valueOf(average));
    }
}

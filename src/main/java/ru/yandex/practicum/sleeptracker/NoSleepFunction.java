package ru.yandex.practicum.sleeptracker;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;


public class NoSleepFunction implements Function<List<SleepingSession>, SleepAnalysisResult> {


    @Override
    public SleepAnalysisResult apply(List<SleepingSession> sessions) {

        Set<LocalDate> nightsWithSleep = sessions.stream()
                .filter(this::isNightSession)
                .map(this::getNightDate)
                .collect(Collectors.toSet());

        LocalDate firstNight = nightsWithSleep.stream()
                .min(LocalDate::compareTo)
                .get();

        LocalDate lastNight = nightsWithSleep.stream()
                .max(LocalDate::compareTo)
                .get();

        long totalNights =
                ChronoUnit.DAYS.between(firstNight, lastNight) + 1;

        long sleeplessNights =
                totalNights - nightsWithSleep.size();

        return new SleepAnalysisResult(
                "Количество бессонных ночей",
                String.valueOf(sleeplessNights)
        );
    }
    // шаг 1 - ночная сессия или нет

    private boolean isNightSession(SleepingSession session) {

        return session.getFallAsleepTime().toLocalDate()
                .isBefore(session.getWakeUpTime().toLocalDate())
                ||
                session.getFallAsleepTime().getHour() < 6;
    }

    // шаг 2 - получение даты ночных сессий
    private LocalDate getNightDate(SleepingSession session) {

        if (session.getFallAsleepTime().getHour() < 6) {
            return session.getFallAsleepTime()
                    .toLocalDate()
                    .minusDays(1);
        }

        return session.getFallAsleepTime().toLocalDate();
    }
}





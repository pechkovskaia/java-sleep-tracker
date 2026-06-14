package ru.yandex.practicum.sleeptracker;

import java.util.List;
import java.util.function.Function;

public class ChronotypeFunction
        implements Function<List<SleepingSession>, SleepAnalysisResult> {

    @Override
    public SleepAnalysisResult apply(List<SleepingSession> sessions) {

        long owls = sessions.stream()
                .filter(this::isOwl)
                .count();

        long larks = sessions.stream()
                .filter(this::isLark)
                .count();

        long pigeons = sessions.size() - owls - larks;

        Chronotypes result;

        if (owls > larks && owls > pigeons) {
            result = Chronotypes.OWL;
        } else if (larks > owls && larks > pigeons) {
            result = Chronotypes.LARK;
        } else {
            result = Chronotypes.PIGEON;
        }

        return new SleepAnalysisResult(
                "Хронотип пользователя",
                result.name()
        );
    }

    private boolean isOwl(SleepingSession session) {
        return session.getFallAsleepTime().getHour() >= 23
                && session.getWakeUpTime().getHour() >= 9;
    }

    private boolean isLark(SleepingSession session) {
        return session.getFallAsleepTime().getHour() < 22
                && session.getWakeUpTime().getHour() < 7;
    }
}
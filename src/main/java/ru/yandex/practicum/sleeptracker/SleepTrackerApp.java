package ru.yandex.practicum.sleeptracker;
// основной класс

import java.io.IOException;
import java.util.List;
import java.util.function.Function;

public class SleepTrackerApp {

    private static final List<Function<List<SleepingSession>, SleepAnalysisResult>> ANALYZERS = List.of(
            new TotalSessionsFunction(),
            new MinDurationFunction(),
            new MaxDurationFunction(),
            new AverageDurationFunction(),
            new BadQualityCountFunction(),
            new NoSleepFunction(),
            new ChronotypeFunction()
    );

    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            System.out.println("Укажите путь к файлу");
            return;
        }

        List<SleepingSession> sessions = SleepSessionReader.readFromFile(args[0]);

        ANALYZERS.stream().map(function -> function.apply(sessions)).forEach(System.out ::println);


    }
}
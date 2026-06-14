package ru.yandex.practicum.sleeptracker;

// вывод на экран результата анализа сна
public class SleepAnalysisResult {
    private final String description;
    private final String value;

    public SleepAnalysisResult(String description, String value) {
        this.description = description;
        this.value = value;
    }

    @Override
    public String toString() {
        return description + ": " + value;
    }

    public String getValue() {
        return value;
    }
}

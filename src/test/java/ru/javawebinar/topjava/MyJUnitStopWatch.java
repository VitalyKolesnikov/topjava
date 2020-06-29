package ru.javawebinar.topjava;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.junit.AssumptionViolatedException;
import org.junit.rules.Stopwatch;
import org.junit.runner.Description;

public class MyJUnitStopWatch extends Stopwatch{

    public static Map<String, Long> results = new HashMap<>();

    private static void logInfo(Description description, String status, long nanos) {
        String testName = description.getMethodName();
        System.out.println(String.format("Test %s %s, spent %d microseconds",
                testName, status, TimeUnit.NANOSECONDS.toMicros(nanos)));
    }

    public static void printResults() {
        System.out.println("==============================Tests summary==============================");
        results.forEach((key, value) -> System.out.println(String.format("Test %s -  %d microseconds",
                key, TimeUnit.NANOSECONDS.toMicros(value))));
        System.out.println("=========================================================================");
    }

    @Override
    protected void succeeded(long nanos, Description description) {
        logInfo(description, "succeeded", nanos);
        results.put(description.getMethodName(), nanos);
    }

    @Override
    protected void failed(long nanos, Throwable e, Description description) {
        logInfo(description, "failed", nanos);
    }

    @Override
    protected void skipped(long nanos, AssumptionViolatedException e, Description description) {
        logInfo(description, "skipped", nanos);
    }

    @Override
    protected void finished(long nanos, Description description) {
        logInfo(description, "finished", nanos);
    }
}
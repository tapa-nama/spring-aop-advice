package com.thoughtworks.grad.concretepage;

import java.util.ArrayList;
import java.util.List;

public class Logger {
    private static List<String> logs = new ArrayList<>();

    public static void log(String str) {
        logs.add(str);
    }

    public static List<String> getLogs() {
        return logs;
    }

    public static void clear() {
        logs.clear();
    }
}

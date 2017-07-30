package com.khongchilacode.l4junit;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LogFileHandler implements LogVerifer {

    private static LogVerifer current;
    private List<String> logEntries;
    private File logFile;
    private int currentLine;

    public static LogVerifer getLogHandler(String filePath) {
        if (current == null) {
            current = new LogFileHandler(filePath);
        }
        return current;
    }

    private LogFileHandler(String filePath) {
        logFile = new File(filePath);
        logEntries = new ArrayList<>();
        currentLine = 0;
    }

    public void startHook() {
        try (BufferedReader reader = new BufferedReader(new FileReader(logFile))) {

            while (reader.readLine() != null) {
                currentLine++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stopHook() {
        reloadContent();
    }

    public boolean contains(String logEntry) {
        return logEntries.stream().anyMatch(s -> s.contains(logEntry));
    }

    public String getLogContent() {
        return logEntries.stream().collect(Collectors.joining());
    }

    public void reloadContent() {
        try (BufferedReader reader = new BufferedReader(new FileReader(logFile))) {
            for (int i = 0; i < currentLine; i++) {
                reader.readLine();
            }
            String line;
            while ((line = reader.readLine()) != null) {
                logEntries.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<String> matches(String pattern) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Stream<String> getLogStream() {
        // TODO Auto-generated method stub
        return null;
    }

}

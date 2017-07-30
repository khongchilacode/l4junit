package com.khongchilacode.l4junit;

import java.io.StringWriter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.log4j.Layout;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.WriterAppender;

public class LogSimpleVerifier implements LogVerifer {
    
    private static LogVerifer current;
    private List<String> logEntries;
    private StringWriter logContent;
    private WriterAppender stubAppender;
    private Class<?> testClazz;
    
    public static LogVerifer getLogVerifier(Class<?> testClazz) {
        if (current == null) {
            current = new LogSimpleVerifier(testClazz);
        }
        return current;
    }
    
    private LogSimpleVerifier(Class<?> testClazz) {
        this.testClazz = testClazz;
        logContent = new StringWriter();
        Layout stubLayout = new PatternLayout("%m%n");
        
        stubAppender = new WriterAppender(stubLayout, logContent);
        stubAppender.setEncoding("UTF-8");
        stubAppender.setThreshold(Level.ALL);
    }

    public void startHook() {
        Logger logger = Logger.getLogger(testClazz);
        logger.addAppender(stubAppender);
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
        String content = logContent.toString();
        logEntries = Arrays.asList(content.split(System.getProperty("line.separator")));
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

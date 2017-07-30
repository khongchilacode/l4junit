package com.khongchilacode.l4junit.model;

import org.apache.log4j.Level;

public class LogSimpleModel {

    private Class<?> testClazz;
    private Level logLevel;
    private String message;
    private int time;

    public Class<?> getTestClazz() {
        return testClazz;
    }

    public void setTestClazz(Class<?> testClazz) {
        this.testClazz = testClazz;
    }

    public Level getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(Level logLevel) {
        this.logLevel = logLevel;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

}

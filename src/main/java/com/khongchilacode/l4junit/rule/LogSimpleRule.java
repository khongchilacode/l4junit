package com.khongchilacode.l4junit.rule;

import org.apache.log4j.Level;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import com.khongchilacode.l4junit.annotation.LogExpected;
import com.khongchilacode.l4junit.model.LogSimpleModel;
import com.khongchilacode.l4junit.statement.LogSimpleStatement;

public class LogSimpleRule implements TestRule {

    private Class<?> testClazz;

    public LogSimpleRule(Class<?> testClazz) {
        this.testClazz = testClazz;
    }

    @Override
    public Statement apply(Statement base, Description description) {
        LogSimpleModel model = new LogSimpleModel();

        LogExpected expected = description.getAnnotation(LogExpected.class);
        model.setMessage(expected.msg());
        switch (expected.level()) {
            case "info":
                model.setLogLevel(Level.INFO);
                break;
            case "debug":
                model.setLogLevel(Level.DEBUG);
                break;
            default:
                model.setLogLevel(Level.ALL);
        }

        return new LogSimpleStatement(base, this.testClazz, model);
    }

}

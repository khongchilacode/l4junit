package com.khongchilacode.l4junit.statement;

import org.junit.runners.model.Statement;

import com.khongchilacode.l4junit.LogSimpleVerifier;
import com.khongchilacode.l4junit.LogVerifer;
import com.khongchilacode.l4junit.model.LogSimpleModel;

public class LogSimpleStatement extends Statement {
    
    private Statement baseStatement;
    private LogVerifer logVerifier;
    
    public LogSimpleStatement(Statement base, Class<?> testClazz, LogSimpleModel model) {
        this.baseStatement = base;
        this.logVerifier = LogSimpleVerifier.getLogVerifier(testClazz);
    }

    @Override
    public void evaluate() throws Throwable {
        try {
            beforeTest();
            baseStatement.evaluate();
        } finally {
            afterTest();
        }
        assertTest();
    }
    
    private void beforeTest() {
        this.logVerifier.startHook();
    }
    
    private void afterTest() {
        this.logVerifier.stopHook();
    }
    
    private void assertTest() {
        
    }

}

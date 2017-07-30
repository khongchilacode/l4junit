package com.khongchilacode.l4junit;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    
    private App app = new App();
    private LogVerifer logHandler = LogFileHandler.getLogHandler("log.out");
    
    @Before
    public void setUp() {
        logHandler.startHook();
    }
    
    @After
    public void tearDown() {
        
    }

    @Test
    public void testApp() {
        app.test();
        logHandler.stopHook();
        assertTrue(logHandler.contains("hihi"));
    }
}

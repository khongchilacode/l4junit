package com.khongchilacode.l4junit;

import java.util.List;
import java.util.stream.Stream;

/**
 * Hook the logging event and get the log content. <br />
 * Verify an entry if it exists or list all logs that match the specific
 * pattern.
 * 
 * @author minhnn
 * @since J2SE 1.8
 *
 */
public interface LogVerifer {
    /**
     * Start stubbing the log appender to capture the log content.
     */
    void startHook();

    /**
     * Stop and free the stubbed appender. Re-load the content.
     */
    void stopHook();

    /**
     * Verify if there is any entry containing a specific string.
     * 
     * @param logEntry string to verify
     * @return true - if there is any entry containing the string
     */
    boolean contains(String logEntry);
    
    /**
     * List all the entries that match the pattern.
     * 
     * @param pattern the regex pattern to test
     * @return List<String> list all the entries matched
     */
    List<String> matches(String pattern);
    
    /**
     * Get the log stream.
     * 
     * @return the log stream
     */
    Stream<String> getLogStream();

    /**
     * Collect all the log into one string and return it.
     * 
     * @return the log content
     */
    String getLogContent();

    /**
     * Reload the log content.
     */
    void reloadContent();
}

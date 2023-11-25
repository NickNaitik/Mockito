package com.example.Mockito.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomLogger {

    private final Logger logger;

    public CustomLogger(Class<?> clazz) {
        this.logger = LoggerFactory.getLogger(clazz);
    }

    // Custom info method with four string parameters
    public void info(String param1, String param2, String param3, String param4) {
        logger.info("Custom Info: {} {} {} {}", param1, param2, param3, param4);
    }

    // Custom info method with three strings and an object parameter
    public void info(String param1, String param2, String param3, Object param4) {
        logger.info("Custom Info: {} {} {} {}", param1, param2, param3, param4);
    }

    // Similarly, you can create custom methods for other log levels

    // Custom error method with four string parameters
    public void error(String param1, String param2, String param3, String param4) {
        logger.error("Custom Error: {} {} {} {}", param1, param2, param3, param4);
    }

    // Custom debug method with four string parameters
    public void debug(String param1, String param2, String param3, String param4) {
        logger.debug("Custom Debug: {} {} {} {}", param1, param2, param3, param4);
    }

    // Custom exception method with an exception and additional string parameters
    public void exception(String message, Throwable throwable, String param1, String param2) {
        logger.error("Custom Exception: {} {} {}", message, param1, param2, throwable);
    }

    // Other custom logging methods as needed

    // You can also expose the underlying logger if needed
    public Logger getLogger() {
        return logger;
    }
}
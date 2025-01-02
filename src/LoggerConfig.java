package com.supermarket.management;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LoggerConfig {
    static {
        PropertyConfigurator.configure("log4j.properties");
    }

    public static Logger getLogger(Class<?> clazz) {
        return Logger.getLogger(clazz);
    }
}

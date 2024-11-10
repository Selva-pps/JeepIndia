package com.utilis;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerUtil {
    public static Logger log = LogManager.getLogger(LoggerUtil.class);

    public static void logInfo(String message) {
        log.info(message);
    }

    public static void logError(String message) {
        log.error(message); 
    }
}

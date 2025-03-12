package org.example.designPattern.LoggingFramework.Approach2;

import org.example.designPattern.LoggingFramework.Approach2.logappender.LogAppender;

import java.time.Instant;
import java.util.Date;

public class Logger {
    LoggerConfig loggerConfig;
    static Logger logger;

    private Logger(LoggerConfig loggerConfig) {
        this.loggerConfig = loggerConfig;

    }
    public static Logger getLogger(LoggerConfig loggerConfig) {
        if(logger == null) {
            logger = new Logger(loggerConfig);
        }
        return logger;
    }

    public void setLoggerConfig(LoggerConfig loggerConfig) {
        this.loggerConfig = loggerConfig;
    }

    private void log(LogLevel logLevel, String message) {
        LogMessage logMessage = new LogMessage( message, Date.from(Instant.now()));
        if(loggerConfig.getLogLevel().ordinal() <= logLevel.ordinal()) {
            loggerConfig.logAppender.append(logMessage);
        }
    }


    public void info(String message) {
        log(LogLevel.INFO, message);
    }

    public void debug(String message) {
        log(LogLevel.DEBUG, message);
    }

    public void error(String message) {
        log(LogLevel.ERROR, message);
    }

}

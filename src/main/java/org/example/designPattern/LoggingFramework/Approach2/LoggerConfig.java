package org.example.designPattern.LoggingFramework.Approach2;

import org.example.designPattern.LoggingFramework.Approach2.logappender.LogAppender;

public class LoggerConfig {
    LogLevel logLevel;
    LogAppender logAppender;

    public void setLogLevel(LogLevel logLevel) {
        this.logLevel = logLevel;
    }

    public LogLevel getLogLevel() {
        return this.logLevel;
    }

    public void setLogAppender(LogAppender logAppender) {
        this.logAppender = logAppender;
    }

    public LogAppender getLogAppender() {
        return this.logAppender;
    }

}

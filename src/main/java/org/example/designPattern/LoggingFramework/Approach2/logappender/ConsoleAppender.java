package org.example.designPattern.LoggingFramework.Approach2.logappender;

import org.example.designPattern.LoggingFramework.Approach2.LogMessage;
import org.example.designPattern.LoggingFramework.Approach2.LoggerConfig;

public class ConsoleAppender implements LogAppender{
    @Override
    public void append(LogMessage logMessage) {
        System.out.println(logMessage.getMessage());
    }
}

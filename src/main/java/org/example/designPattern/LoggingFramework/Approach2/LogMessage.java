package org.example.designPattern.LoggingFramework.Approach2;

import lombok.Getter;

import java.util.Date;

@Getter
public class LogMessage {
    String message;
    Date date;

    public LogMessage(String logMessage, Date date) {
        this.message = logMessage;
        this.date = date;
    }
}

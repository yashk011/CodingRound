package org.example.LLDQuestions.LoggingFramework.Approach2.logappender;

import org.example.LLDQuestions.LoggingFramework.Approach2.LogMessage;

public class ConsoleAppender implements LogAppender{
    @Override
    public void append(LogMessage logMessage) {
        System.out.println(logMessage.getMessage());
    }
}

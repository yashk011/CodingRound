package org.example.LLDQuestions.LoggingFramework.Approach2.logappender;

import org.example.LLDQuestions.LoggingFramework.Approach2.LogMessage;

public interface LogAppender {

    public void append(LogMessage logMessage);
}

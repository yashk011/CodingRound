package org.example.LLDQuestions.LoggingFramework.Approach2;

import org.example.LLDQuestions.LoggingFramework.Approach2.logappender.ConsoleAppender;

public class LoggingFrameworkDemo {
    public static void main(String[] args) {
        LoggerConfig loggerConfig = new LoggerConfig();
        loggerConfig.setLogAppender(new ConsoleAppender());
        loggerConfig.setLogLevel(LogLevel.INFO);

        Logger logger = Logger.getLogger(loggerConfig);

        logger.debug("Heyy There !!");
        logger.info("My Name is Yas");
        logger.error("Oops a Typo ... My Name is Yash");

    }
}

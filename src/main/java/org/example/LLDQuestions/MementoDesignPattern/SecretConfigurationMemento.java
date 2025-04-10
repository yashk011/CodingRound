package org.example.LLDQuestions.MementoDesignPattern;

import java.util.Date;

public class SecretConfigurationMemento {
    String key;
    String value;
    Date updatedDate;

    public SecretConfigurationMemento(SecretConfiguration secretConfiguration) {
        this.key = secretConfiguration.key;
        this.value = secretConfiguration.value;
        this.updatedDate = secretConfiguration.updatedDate;
    }

}

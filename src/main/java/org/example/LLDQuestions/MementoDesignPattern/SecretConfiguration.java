package org.example.LLDQuestions.MementoDesignPattern;

import java.time.Instant;
import java.util.Date;

public class SecretConfiguration {
    String key;
    String value;
    Date updatedDate;

    public SecretConfiguration(String key, String value) {
        this.key = key;
        this.value = value;
        this.updatedDate = Date.from(Instant.now());
    }

    public void setValue(String value) {
        this.value = value;
        this.updatedDate = Date.from(Instant.now());
    }

    public SecretConfigurationMemento createMemento() {
        SecretConfigurationMemento secretConfigurationMemento = new SecretConfigurationMemento(this);
        return secretConfigurationMemento;
    }
}

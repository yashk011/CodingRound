package org.example.LLDQuestions.MementoDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class SecretConfigCareTaker {
    List<SecretConfigurationMemento> secretConfigurationMementoList;

    public SecretConfigCareTaker() {
        this.secretConfigurationMementoList = new ArrayList<>();
    }

    public void addMemento(SecretConfigurationMemento secretConfigurationMemento) {
        secretConfigurationMementoList.add(secretConfigurationMemento);
    }

    public SecretConfigurationMemento undo() {
        if(!secretConfigurationMementoList.isEmpty()) {
            int index = secretConfigurationMementoList.size();
            SecretConfigurationMemento secretConfigurationMemento = secretConfigurationMementoList.get(index-1);
            secretConfigurationMementoList.remove(index-1);
            return secretConfigurationMemento;
        }

        return null;
    }

}

package org.example.LLDQuestions.MementoDesignPattern;

public class Main {

    public static void main(String[] args) {
        SecretConfigCareTaker secretConfigCareTaker = new SecretConfigCareTaker();

        SecretConfiguration secretConfiguration = new SecretConfiguration("db_primary_key", "AB123EDHB2");
        SecretConfigurationMemento snapshot = secretConfiguration.createMemento();
        secretConfigCareTaker.addMemento(snapshot);

        secretConfiguration.setValue("LLLLIBNEBNN122");
        SecretConfigurationMemento snapshot2 = secretConfiguration.createMemento();
        secretConfigCareTaker.addMemento(snapshot2);

        secretConfiguration.setValue("&&&&&&993849844");
//        SecretConfigurationMemento snapshot3 = secretConfiguration.createMemento();
//        secretConfigCareTaker.addMemento(snapshot3);

        System.out.println("Current Value " + secretConfiguration.key + " = " + secretConfiguration.value);
        System.out.println("Reverting to previous configuration");
        SecretConfigurationMemento revertedValue = secretConfigCareTaker.undo();

        secretConfiguration.setValue(revertedValue.value);
        System.out.println("Reverted Value " + secretConfiguration.key + " = " + secretConfiguration.value);

        System.out.println("Reverting to previous configuration");
        SecretConfigurationMemento revertedValue2 = secretConfigCareTaker.undo();

        secretConfiguration.setValue(revertedValue2.value);
        System.out.println("Reverted Value " + secretConfiguration.key + " = " + secretConfiguration.value);

    }
}

package org.example.designPattern.CommandDesignPattern;

public class Client {
    public static void main(String[] args) {
        RemoteControl remoteControl = new RemoteControl();
        remoteControl.setCommand(new TurnONAcCommand());
        remoteControl.pressButton();

        remoteControl.undo();
//        remoteControl.setCommand(new TurnOFFAcCommand());
//        remoteControl.pressButton();


    }
}

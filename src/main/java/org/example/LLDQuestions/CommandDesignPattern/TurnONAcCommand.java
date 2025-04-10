package org.example.LLDQuestions.CommandDesignPattern;

public class TurnONAcCommand implements Command{

    AirConditioner AC = new AirConditioner();

    @Override
    public void execute() {
        this.AC.turnOn();
    }

    @Override
    public void undo() {
        this.AC.turnOff();
    }
}

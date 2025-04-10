package org.example.LLDQuestions.CommandDesignPattern;

public class TurnOFFAcCommand implements Command{

    AirConditioner AC = new AirConditioner();

    public void setAC(AirConditioner AC) {
        this.AC = AC;
    }

    @Override
    public void execute() {
        this.AC.turnOff();
    }

    @Override
    public void undo() {
        this.AC.turnOn();
    }
}

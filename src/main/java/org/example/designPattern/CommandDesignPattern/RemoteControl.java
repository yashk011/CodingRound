package org.example.designPattern.CommandDesignPattern;

import java.util.Stack;

public class RemoteControl {
    Command command;
    Stack<Command> commandHistory;

    public RemoteControl(){
        commandHistory = new Stack<>();
    }
    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
        commandHistory.add(command);
    }

    public void undo() {
        System.out.println("Undoing AC Operation");
        Command command1 = commandHistory.pop();
        command1.undo();
    }
}

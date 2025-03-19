package org.example.designPattern.AdapterDesignPattern.weightMachineServer;

public class WeightMachine implements IWeightMachine{
    @Override
    public int getWeightInPounds() {
        return 28;
    }
}

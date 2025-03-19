package org.example.designPattern.AdapterDesignPattern.Adapter;

import org.example.designPattern.AdapterDesignPattern.weightMachineServer.IWeightMachine;

public class WeightMachineAdapter implements IWeightMachineAdapter{
    IWeightMachine weightMachine;

    public WeightMachineAdapter(IWeightMachine weightMachine) {
        this.weightMachine = weightMachine;
    }

    @Override
    public double getWeightInKgs() {
        int weightInPounds = weightMachine.getWeightInPounds();

        double weightInKgs = Math.round(weightInPounds/(double) 2.2);
        return weightInKgs;
    }
}

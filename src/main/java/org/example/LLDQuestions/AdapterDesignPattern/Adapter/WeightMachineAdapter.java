package org.example.LLDQuestions.AdapterDesignPattern.Adapter;

import org.example.LLDQuestions.AdapterDesignPattern.weightMachineServer.IWeightMachine;

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

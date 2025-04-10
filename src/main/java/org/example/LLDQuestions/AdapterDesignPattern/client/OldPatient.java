package org.example.LLDQuestions.AdapterDesignPattern.client;

import org.example.LLDQuestions.AdapterDesignPattern.Adapter.WeightMachineAdapter;
import org.example.LLDQuestions.AdapterDesignPattern.weightMachineServer.WeightMachine;

public class OldPatient {
    public static void main(String[] args) {
        WeightMachineAdapter weightMachineAdapter = new WeightMachineAdapter(new WeightMachine());
        System.out.println(weightMachineAdapter.getWeightInKgs());
    }
}

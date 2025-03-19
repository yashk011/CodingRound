package org.example.designPattern.AdapterDesignPattern.client;

import org.example.designPattern.AdapterDesignPattern.Adapter.WeightMachineAdapter;
import org.example.designPattern.AdapterDesignPattern.weightMachineServer.WeightMachine;

public class OldPatient {
    public static void main(String[] args) {
        WeightMachineAdapter weightMachineAdapter = new WeightMachineAdapter(new WeightMachine());
        System.out.println(weightMachineAdapter.getWeightInKgs());
    }
}

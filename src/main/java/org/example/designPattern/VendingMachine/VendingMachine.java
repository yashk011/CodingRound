package org.example.designPattern.VendingMachine;


import lombok.Getter;
import lombok.Setter;
import org.example.designPattern.VendingMachine.state.IdealState;
import org.example.designPattern.VendingMachine.state.State;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Setter
@Getter
public class VendingMachine {
    State currentState;
    HashMap<Integer, VendingMachineShelf> vendingMachineShelf;
    List<Integer> coins;

    public VendingMachine() {
        vendingMachineShelf = new HashMap<>();
        currentState = new IdealState();
        coins = new ArrayList<>();
        populateInventory();
    }

    private void populateInventory() {
        vendingMachineShelf.put(100, new VendingMachineShelf(new VendingMachineItem(25, "Parle G"), true));
        vendingMachineShelf.put(101, new VendingMachineShelf(new VendingMachineItem(25, "Kurkure"), true));
        vendingMachineShelf.put(102, new VendingMachineShelf(new VendingMachineItem(25, "Lays"), true));
        vendingMachineShelf.put(104, new VendingMachineShelf(new VendingMachineItem(1000, "Bingo"), true));
    }

    public void addCoin(int coin) {
        coins.add(coin);
    }
}
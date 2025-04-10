package org.example.LLDQuestions.VendingMachine;

public class VendingMachineDemo {

    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();

        vendingMachine.getCurrentState().pressCollectCashButton(vendingMachine);

        vendingMachine.getCurrentState().addCoin(vendingMachine, Coin.DIME);
        vendingMachine.getCurrentState().addCoin(vendingMachine, Coin.CENT);

        vendingMachine.getCurrentState().pressSelectProductButton(vendingMachine);

        vendingMachine.getCurrentState().selectProduct(vendingMachine, 100);

        vendingMachine.getCurrentState().dispenseProduct(vendingMachine);
    }
}

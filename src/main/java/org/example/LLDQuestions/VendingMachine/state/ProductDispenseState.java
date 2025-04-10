package org.example.LLDQuestions.VendingMachine.state;

import lombok.SneakyThrows;
import org.example.LLDQuestions.VendingMachine.Coin;
import org.example.LLDQuestions.VendingMachine.VendingMachine;

public class ProductDispenseState implements State{

    public ProductDispenseState() {
        System.out.println("Product Moved to Collect Product Dispense State");
    }

    @Override
    public void dispenseProduct(VendingMachine vendingMachine) {
        System.out.println("Dispatching Product");
        vendingMachine.setCurrentState(new IdealState());
    }

    @Override
    public void addCoin(VendingMachine vendingMachine, Coin coin) {
        System.out.println("Cannot push cash now");
    }

    @Override
    public void pressCollectCashButton(VendingMachine vendingMachine) {
    }

    @Override
    public void selectProduct(VendingMachine vendingMachine, int productCode) {
    }

    @Override
    public void pressSelectProductButton(VendingMachine vendingMachine) {
        return ;
    }

    @Override
    public int refundMoney(VendingMachine vendingMachine) {
        System.out.println("Returned the full amount back in the Coin Dispense Tray");
        vendingMachine.setCurrentState(new IdealState());
        return 25;
    }

    @Override
    public void getChange(VendingMachine vendingMachine, int change) {
    }

    @Override
    @SneakyThrows
    public void updateInventory(VendingMachine vendingMachine) {
        throw new Exception("Cannot Update Inv during dispense state");
    }
}

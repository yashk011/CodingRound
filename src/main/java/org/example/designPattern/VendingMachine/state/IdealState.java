package org.example.designPattern.VendingMachine.state;

import lombok.SneakyThrows;
import org.example.designPattern.VendingMachine.Coin;
import org.example.designPattern.VendingMachine.VendingMachine;

public class IdealState implements State{

    public IdealState() {
        System.out.println("Product Moved to Collect Ideal State");
    }

    @Override
    @SneakyThrows
    public void dispenseProduct(VendingMachine vendingMachine) {
        throw new Exception("Select Product First");
    }

    @Override
    @SneakyThrows
    public void addCoin(VendingMachine vendingMachine, Coin coin) {
        throw new Exception("Please select press collect cash button");
    }

    @Override
    public void pressCollectCashButton(VendingMachine vendingMachine) {
        System.out.println("Moving to Collect Cash Button");
        vendingMachine.setCurrentState(new CollectCashState());
    }

    @Override
    @SneakyThrows
    public void selectProduct(VendingMachine vendingMachine, int productCode) {
        throw new Exception("Please select press collect cash button");
    }

    @Override
    @SneakyThrows
    public void pressSelectProductButton(VendingMachine vendingMachine) {
        throw new Exception("Please select press collect cash button");
    }

    @Override
    @SneakyThrows
    public int refundMoney(VendingMachine vendingMachine) {
        throw new Exception("you can not get refunded in idle state");
    }

    @Override
    @SneakyThrows
    public void getChange(VendingMachine vendingMachine, int change) {
        throw new Exception("you can not get change in idle state");
    }

    @Override
    public void updateInventory(VendingMachine vendingMachine) {
        System.out.println("Adding Product To Inventory");
    }
}

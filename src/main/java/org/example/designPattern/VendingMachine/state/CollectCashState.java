package org.example.designPattern.VendingMachine.state;

import lombok.SneakyThrows;
import org.example.designPattern.VendingMachine.Coin;
import org.example.designPattern.VendingMachine.VendingMachine;

public class CollectCashState implements State{

    public CollectCashState() {
        System.out.println("Product Moved to Collect Cash State");
    }

    @Override
    @SneakyThrows
    public void dispenseProduct(VendingMachine vendingMachine) {
        throw new Exception("Cannot Dispense Product , First Give Cash");
    }

    @Override
    public void addCoin(VendingMachine vendingMachine, Coin coin) {
        System.out.println("Collecting Cash");
        vendingMachine.addCoin(coin.val);
    }

    @Override
    public void pressCollectCashButton(VendingMachine vendingMachine) {
        return;
    }

    @Override
    @SneakyThrows
    public void selectProduct(VendingMachine vendingMachine, int productNumber) {
        throw new Exception("First Select Product Select Button");
    }

    @Override
    public void pressSelectProductButton(VendingMachine vendingMachine) {
        System.out.println("Product Selection Button Selected");
        vendingMachine.setCurrentState(new ProductSelectionState());
    }

    @Override
    @SneakyThrows
    public int refundMoney(VendingMachine vendingMachine) {
        System.out.println("Returned the full amount back in the Coin Dispense Tray");
        vendingMachine.setCurrentState(new IdealState());
        return 25;

    }

    @Override
    @SneakyThrows
    public void getChange(VendingMachine vendingMachine, int change) {
        throw new Exception("Cannot Get Change in Collect Cash State");
    }

    @Override
    @SneakyThrows
    public void updateInventory(VendingMachine vendingMachine) {
        throw new Exception("Cannot Update is in Collect Cash State");
    }


}

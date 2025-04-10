package org.example.LLDQuestions.VendingMachine.state;

import lombok.SneakyThrows;
import org.example.LLDQuestions.VendingMachine.Coin;
import org.example.LLDQuestions.VendingMachine.VendingMachine;
import org.example.LLDQuestions.VendingMachine.VendingMachineShelf;

public class ProductSelectionState implements State{

    public ProductSelectionState() {
        System.out.println("Product Moved to Product Selection State");
    }

    @Override
    public void dispenseProduct(VendingMachine vendingMachine) {

    }

    @Override
    public void addCoin(VendingMachine vendingMachine, Coin coin) {

    }

    @Override
    public void pressCollectCashButton(VendingMachine vendingMachine) {

    }

    @Override
    @SneakyThrows
    public void selectProduct(VendingMachine vendingMachine, int productCode) {
        VendingMachineShelf vendingMachineShelf = vendingMachine.getVendingMachineShelf()
                .get(productCode);

        if(!vendingMachineShelf.isAvailable())
            throw new Exception("Item not available!!");

        System.out.println("Product - " + vendingMachineShelf.getVendingMachineItem().getName() + " Price - " + vendingMachineShelf.getVendingMachineItem().getPrice());
        int cost = vendingMachine.getVendingMachineShelf().get(productCode).getVendingMachineItem().getPrice();
        int paidByUser = 0;

        for(int coin: vendingMachine.getCoins()) {
            paidByUser+=coin;
        }

        if(paidByUser < cost) {
            refundMoney(vendingMachine);
            throw new Exception("Full Refund Given to user as not sufficient money ");
        }
        else {
            int change = paidByUser-cost;
            getChange(vendingMachine, change);
            System.out.println("Product Selected");
        }
        vendingMachine.setCurrentState(new ProductDispenseState());
    }

    @Override
    public void pressSelectProductButton(VendingMachine vendingMachine) {
        return;
    }

    @Override
    public int refundMoney(VendingMachine vendingMachine) {
        System.out.println("Returned the full amount back in the Coin Dispense Tray");
        vendingMachine.setCurrentState(new IdealState());
        return 25;
    }

    @Override
    public void getChange(VendingMachine vendingMachine, int change) {
        System.out.println("Returned the change in the Coin Dispense Tray: " + change);
    }

    @Override
    public void updateInventory(VendingMachine vendingMachine) {

    }
}

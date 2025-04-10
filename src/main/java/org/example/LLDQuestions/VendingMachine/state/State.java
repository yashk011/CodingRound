package org.example.LLDQuestions.VendingMachine.state;

import org.example.LLDQuestions.VendingMachine.Coin;
import org.example.LLDQuestions.VendingMachine.VendingMachine;

public interface State {
    public void dispenseProduct(VendingMachine vendingMachine);

    public void addCoin(VendingMachine vendingMachine, Coin coin);

    public void pressCollectCashButton(VendingMachine vendingMachine);
    public void selectProduct(VendingMachine vendingMachine, int productCode);
    public void pressSelectProductButton(VendingMachine vendingMachine);

    public int refundMoney(VendingMachine vendingMachine);
    public void getChange(VendingMachine vendingMachine, int change);
    public void updateInventory(VendingMachine vendingMachine);
}

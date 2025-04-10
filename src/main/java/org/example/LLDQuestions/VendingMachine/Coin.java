package org.example.LLDQuestions.VendingMachine;

public enum Coin {
    QUARTER(25),
    DIME(1),
    CENT(50);

    public int val;

    Coin(int val) {
        this.val = val;
    }
}

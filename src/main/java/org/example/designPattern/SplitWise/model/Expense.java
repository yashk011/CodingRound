package org.example.designPattern.SplitWise.model;

import lombok.Getter;

import java.util.ArrayList;

@Getter
public class Expense {
    String expenseId;
    String description;
    User paidBy;
    int amount;
    SplitType splitType;
    ArrayList<Split> splitDetails = new ArrayList<>();

    public Expense(String expenseId,
                   String description,
                   User paidBy,
                   int amount,
                   SplitType splitType,
                   ArrayList<Split> splitDetails) {
        this.expenseId = expenseId;
        this.description = description;
        this.paidBy = paidBy;
        this.amount = amount;
        this.splitType = splitType;
        this.splitDetails = splitDetails;
    }
}

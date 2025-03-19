package org.example.designPattern.SplitWise.controller;

import org.example.designPattern.SplitWise.model.Expense;
import org.example.designPattern.SplitWise.model.Split;
import org.example.designPattern.SplitWise.model.SplitType;
import org.example.designPattern.SplitWise.model.User;
import org.example.designPattern.SplitWise.validator.ExpenseSplit;
import org.example.designPattern.SplitWise.validator.ExpenseSplitFactory;

import java.util.ArrayList;
import java.util.List;

public class ExpenseController {

    BalanceSheetController balanceSheetController; // Can be a service

    public ExpenseController() {
        balanceSheetController = new BalanceSheetController();
    }

    /*
        Gets all the details required to create an expense
                // Use Expense Service to create an expense object
     */
    public Expense createExpense(String expenseId,
                              String description,
                              ArrayList<Split> splitDetails,
                              SplitType splitType,
                              int amount,
                              User user) {
        ExpenseSplit expenseSplit = ExpenseSplitFactory.getExpenseSplitObject(splitType);
        expenseSplit.validateExpenseRequest(splitDetails,amount);

        // New Expense
        Expense expense = new Expense(expenseId, description, user, amount, splitType, splitDetails);
        balanceSheetController.updateUserBalanceSheet(splitDetails, user, amount);

        return expense;
    }
}

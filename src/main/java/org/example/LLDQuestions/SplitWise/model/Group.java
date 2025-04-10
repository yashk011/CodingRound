package org.example.LLDQuestions.SplitWise.model;


import lombok.Getter;
import org.example.LLDQuestions.SplitWise.controller.ExpenseController;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Group {
    String groupName;
    List<User> groupMembers;
    String groupId;
    List<Expense> expenses;
    ExpenseController expenseController;

    public Group(String groupName, String groupId) {
        groupMembers = new ArrayList<>();
        expenses = new ArrayList<>();
        this.groupId = groupId;
        this.groupName = groupName;
        this.expenseController = new ExpenseController();
    }

    public void addMember(User user) {
        this.groupMembers.add(user);
    }

    /* Create Expenses within a group */
    public Expense createExpense(String expenseId,
                                 String description,
                                 ArrayList<Split> splitDetails,
                                 SplitType splitType,
                                 int amount,
                                 User user) {
        Expense expense =  expenseController.createExpense(expenseId, description,splitDetails, splitType, amount, user);
        expenses.add(expense);
        return expense;
    }
}

package org.example.designPattern.SplitWise.controller;

import org.example.designPattern.SplitWise.model.*;

import java.util.List;
import java.util.Map;

public class BalanceSheetController {

    public void updateUserBalanceSheet(List<Split> splitDetails,
                                       User paidBy,
                                       int expenseAmount) {
        BalanceSheet paidByBalanceSheet = paidBy.getBalanceSheet();

        for(Split split : splitDetails) {
            User borrower = split.getUser();
            BalanceSheet borrowerBalanceSheet = borrower.getBalanceSheet();
            int amountBorrowed = split.getAmountOwed();

            if(split.getUser().equals(paidBy)) {
                continue;
            }
            else {
                paidByBalanceSheet.setTotalAmountGetBack(paidByBalanceSheet.getTotalAmountGetBack() + amountBorrowed);
                borrowerBalanceSheet.setTotalAmountOwed(borrowerBalanceSheet.getTotalAmountOwed() + amountBorrowed);
                // Update Payer's Balance Sheet
                if(paidByBalanceSheet.getUserBalance().containsKey(split.getUser().getUserId())) {
                    Balance balance = paidByBalanceSheet.getUserBalance().get(split.getUser().getUserId());
                    balance.setAmount(balance.getAmount() - amountBorrowed);
                }
                else {
                    Balance balance = new Balance(-1* amountBorrowed);
                    paidByBalanceSheet.getUserBalance().put(split.getUser().getUserId(), balance);
                }

                // Update Borrower's Balance Sheet

                if(borrowerBalanceSheet.getUserBalance().containsKey(paidBy.getUserId())) {
                    Balance balance = borrowerBalanceSheet.getUserBalance().get(paidBy.getUserId());
                    balance.setAmount(balance.getAmount() + amountBorrowed);
                }
                else {
                    Balance balance = new Balance(amountBorrowed);
                    borrowerBalanceSheet.getUserBalance().put(paidBy.getUserId(), balance);
                }
            }

        }
    }

    public void showBalance(User user) {
        BalanceSheet balanceSheet = user.getBalanceSheet();
        Map<String, Balance> balanceMap = balanceSheet.getUserBalance();

        System.out.println("Total User gets back - " + balanceSheet.getTotalAmountGetBack());
        System.out.println("Total User pays - " + balanceSheet.getTotalAmountOwed());

        for(Map.Entry<String, Balance> e : balanceMap.entrySet()) {
            System.out.println(e.getKey());
            System.out.println(e.getValue().getAmount());
        }
    }

}


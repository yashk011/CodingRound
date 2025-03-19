package org.example.designPattern.SplitWise.validator;

import org.example.designPattern.SplitWise.model.Split;

import java.util.List;

public class EqualExpenseSplit implements ExpenseSplit{
    @Override
    public boolean validateExpenseRequest(List<Split> splitList, int totalAmount) {
        return false;
    }
}

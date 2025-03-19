package org.example.designPattern.SplitWise.validator;

import org.example.designPattern.SplitWise.model.Split;

import java.util.List;

public interface ExpenseSplit {
    public boolean validateExpenseRequest(List<Split> splitList, int totalAmount);
}

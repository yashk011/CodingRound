package org.example.LLDQuestions.SplitWise.validator;

import org.example.LLDQuestions.SplitWise.model.Split;

import java.util.List;

public class PercentageExpenseSplit implements ExpenseSplit{
    @Override
    public boolean validateExpenseRequest(List<Split> splitList, int totalAmount) {
        return false;
    }
}

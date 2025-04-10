package org.example.LLDQuestions.SplitWise.validator;

import org.example.LLDQuestions.SplitWise.model.SplitType;

public class ExpenseSplitFactory {

    public static ExpenseSplit getExpenseSplitObject(SplitType splitType) {
        if(splitType.name().equals(SplitType.EQUAL.name()))
            return new EqualExpenseSplit();
        else if(splitType.name().equals(SplitType.PERCENTAGE.name()))
            return new PercentageExpenseSplit();
        else
            return null;
    }
}

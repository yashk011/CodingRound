package org.example.designPattern.SplitWise.model;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class BalanceSheet {
    Map<String, Balance> userBalance;
    @Setter
    int totalAmountOwed;
    @Setter
    int totalAmountGetBack;

    public BalanceSheet() {
        userBalance = new HashMap<>();
        totalAmountOwed = 0;
        totalAmountGetBack = 0;
    }

    public Map<String, Balance> getUserBalance() {
        return this.userBalance;
    }
}

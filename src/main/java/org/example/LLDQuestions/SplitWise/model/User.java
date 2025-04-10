package org.example.LLDQuestions.SplitWise.model;

import lombok.Getter;

@Getter
public class User {
    String userId;
    String name;
    BalanceSheet balanceSheet = new BalanceSheet();

    public User(String userId , String name) {
        this.userId = userId;
        this.name = name;
    }
}

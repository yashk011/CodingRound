package org.example.LLDQuestions.ObjectPoolPattern;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DatabaseConnection {
    String url;
    String userName;
    String password;
    public void connect() {
        System.out.println("Connection Completed");
    }
}

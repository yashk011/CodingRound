package org.example.LLDQuestions.Inventory_Management_System_Zepto.controller;

import org.example.LLDQuestions.Inventory_Management_System_Zepto.model.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserController {
    List<User> userList;

    public UserController(List<User> userList) {
        this.userList = userList;
    }

    public void addUser(User user) {
        userList.add(user);
    }

    public User getUser(String userId) {
        return userList.stream().filter(user -> user.getUserId().equals(userId)).collect(Collectors.toUnmodifiableList()).get(0);
    }
}

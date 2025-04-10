package org.example.LLDQuestions.SplitWise.controller;

import org.example.LLDQuestions.SplitWise.model.User;

import java.util.ArrayList;
import java.util.List;

/*
    - Exposes API to store Users
    - Controller can call UserService to store user
    - For demo purpose, we will store data in controller itself
 */
public class UserController {

    List<User> users ;

    public UserController() {
        users = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public User getUser(String userId) {
        for(User user : users) {
            if(user.getUserId().equals(userId)) {
                return user;
            }
        }
        return null;
    }

    public List<User> getAllUsers() {
        return this.users;
    }

}

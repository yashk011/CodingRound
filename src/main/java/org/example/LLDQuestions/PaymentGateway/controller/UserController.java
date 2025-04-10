package org.example.LLDQuestions.PaymentGateway.controller;

import org.example.LLDQuestions.PaymentGateway.dto.UserDTO;
import org.example.LLDQuestions.PaymentGateway.service.UserService;

public class UserController {
    UserService userService;

    public UserController() {
        this.userService = new UserService();
    }

    public String addUser(UserDTO userDTO) {
        return userService.addUser(userDTO);
    }

    public UserDTO getUser(String userId) {
        return userService.getUser(userId);
    }

}

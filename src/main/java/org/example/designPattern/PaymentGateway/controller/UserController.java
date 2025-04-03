package org.example.designPattern.PaymentGateway.controller;

import org.example.designPattern.PaymentGateway.dto.UserDTO;
import org.example.designPattern.PaymentGateway.model.User;
import org.example.designPattern.PaymentGateway.service.UserService;

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

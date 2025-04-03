package org.example.designPattern.PaymentGateway.service;

import org.example.designPattern.PaymentGateway.dto.UserDTO;
import org.example.designPattern.PaymentGateway.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserService {
    List<User> userList = new ArrayList<>();


    public String addUser(UserDTO userDTO) {
        String id = "U-" + UUID.randomUUID().toString();
        User user = new User();
        user.setUserName(userDTO.getName());
        user.setEmailId(userDTO.getEmailAddress());
        user.setPhoneNumber(userDTO.getPhoneNumber());
        user.setUserId(id);

        userList.add(user);
        return id;
    }

    public UserDTO getUser(String userId) {
        return convertToUserDO(userList
                .stream()
                .filter(user -> user.getUserId().equalsIgnoreCase(userId))
                .findFirst()
                .get());
    }

    private UserDTO convertToUserDO(User user) {
        return new UserDTO(user.getUserName(), user.getEmailId(), user.getPhoneNumber());
    }
}

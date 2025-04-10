package org.example.LLDQuestions.Inventory_Management_System_Zepto.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
public class User {
    String userId;
    String name;
    String address;
    Cart cart;
    List<Order> orders = new ArrayList<>();
}

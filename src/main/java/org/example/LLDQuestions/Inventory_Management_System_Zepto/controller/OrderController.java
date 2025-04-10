package org.example.LLDQuestions.Inventory_Management_System_Zepto.controller;

import org.example.LLDQuestions.Inventory_Management_System_Zepto.model.Order;
import org.example.LLDQuestions.Inventory_Management_System_Zepto.model.User;
import org.example.LLDQuestions.Inventory_Management_System_Zepto.model.WareHouse;

import java.util.ArrayList;
import java.util.List;

public class OrderController {
    List<Order> orderList = new ArrayList<>();

    public Order createNewOrder(User user, WareHouse wareHouse) {
        Order order = new Order(user, wareHouse);
        orderList.add(order);
        return order;
    }

    public void addOrder(Order order) {
        orderList.add(order);
    }

}

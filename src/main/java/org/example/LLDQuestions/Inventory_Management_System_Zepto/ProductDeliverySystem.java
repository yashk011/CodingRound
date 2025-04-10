package org.example.LLDQuestions.Inventory_Management_System_Zepto;

import org.example.LLDQuestions.Inventory_Management_System_Zepto.controller.OrderController;
import org.example.LLDQuestions.Inventory_Management_System_Zepto.controller.UserController;
import org.example.LLDQuestions.Inventory_Management_System_Zepto.controller.WareHouseController;
import org.example.LLDQuestions.Inventory_Management_System_Zepto.model.*;
import org.example.LLDQuestions.Inventory_Management_System_Zepto.strategy.NearestWareHouseSelectionStrategy;

import java.util.List;

public class ProductDeliverySystem {
    UserController userController;
    WareHouseController wareHouseController;
    OrderController orderController;

    public ProductDeliverySystem(List<WareHouse> wareHouseList , List<User> userList) {
        wareHouseController = new WareHouseController(wareHouseList);
        userController = new UserController(userList);
        orderController = new OrderController();
    }

    public User getUser(String userId) {
        return userController.getUser(userId);
    }

    public WareHouse getWareHouse(NearestWareHouseSelectionStrategy nearestWareHouseSelectionStrategy) {
        wareHouseController.setWareHouseSelectionStrategy(nearestWareHouseSelectionStrategy);
        return wareHouseController.getWareHouse();
    }

    public ProductInventory getInventory(WareHouse wareHouse) {
        return wareHouse.getInventory();
    }

    public void addProductToUserCart(User user, Product productToBuy) {
        Cart cart = user.getCart();
        cart.addToCart(productToBuy, 1); // Adding Just 1 product for now !
    }

    public Order placeOrder(User user, WareHouse wareHouse) {
        Order order = orderController.createNewOrder(user, wareHouse);
        return order;
    }

    public void checkout(Order order, UPIPaymentMethod upiPaymentMethod) {
        order.checkout(upiPaymentMethod);
    }
}

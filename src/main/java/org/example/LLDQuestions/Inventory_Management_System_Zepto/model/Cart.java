package org.example.LLDQuestions.Inventory_Management_System_Zepto.model;

import java.util.HashMap;

public class Cart {
    int cartId;
    HashMap<Product, Integer> productVsQuantity = new HashMap<>();

    public void addToCart(Product product , int quantity) {
        productVsQuantity.put(product, quantity);
    }
}

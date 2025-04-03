package org.example.designPattern.Inventory_Management_System_Zepto.model;

import java.util.HashMap;
import java.util.Map;

public class ProductInventory {
    Map<Product, Integer> productInventory;


    public ProductInventory() {
        productInventory = new HashMap<>();
    }

    public Map<Product, Integer> getProductInventory() {
        return productInventory;
    }

    public void updateAmount(Product product, int quantity, boolean add) {
        if(!productInventory.containsKey(product)) {
            System.out.println("Product not available");
            return;
        }
        System.out.println("Current Stock  - " + productInventory.get(product) );
        if(add)
            productInventory.put(product,  productInventory.get(product) + quantity);
        else
            productInventory.put(product,  productInventory.get(product) - quantity);

        System.out.println("Updated Stock  - " + productInventory.get(product) );

    }

    public int getAmount(Product product) {
        return productInventory.getOrDefault(product, 0);
    }

    public void addProduct(Product product, int amount) {
        productInventory.put(product,  productInventory.getOrDefault(product,0) + amount);
    }

    public void removeProduct(Product product) {
    }
}

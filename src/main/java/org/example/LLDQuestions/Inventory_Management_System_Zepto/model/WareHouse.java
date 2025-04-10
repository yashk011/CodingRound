package org.example.LLDQuestions.Inventory_Management_System_Zepto.model;

import java.util.HashMap;

public class WareHouse {
    ProductInventory productInventory;
    String address;

    public WareHouse(ProductInventory productInventory) {
        this.productInventory = productInventory;
        this.address = "DEFAULT_ADDRESS";
    }

    public void removeItemFromInventory(Product product) {
        productInventory.removeProduct(product);
    }

    public void addItemToInventory(Product product, int quantity) {
        productInventory.addProduct(product, quantity);
    }

    public ProductInventory getInventory() {
        return this.productInventory;
    }

    public void updateItemFromInventory(HashMap<Product, Integer> productVsQuantity, boolean add) {
        for(Product product : productVsQuantity.keySet()) {
            productInventory.updateAmount(product,productVsQuantity.get(product) , add);
        }

    }
}

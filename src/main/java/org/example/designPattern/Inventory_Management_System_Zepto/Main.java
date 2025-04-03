package org.example.designPattern.Inventory_Management_System_Zepto;

import org.example.designPattern.Inventory_Management_System_Zepto.model.*;
import org.example.designPattern.Inventory_Management_System_Zepto.strategy.NearestWareHouseSelectionStrategy;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<User> userList = createUserList();
        List<WareHouse> wareHouseList = createWareHouseList();

        ProductDeliverySystem productDeliverySystem = new ProductDeliverySystem(wareHouseList, userList);
        startDemo(productDeliverySystem);
    }

    private static void startDemo(ProductDeliverySystem productDeliverySystem) {
//        1. Get User
        User user = productDeliverySystem.getUser("124");
        System.out.println("User Logged in " + user.getName());

//        2. Get WareHouse Bases on User Preference (User get only 1 Warehouse)
        WareHouse wareHouse = productDeliverySystem.getWareHouse(new NearestWareHouseSelectionStrategy());

//        3. Show All Products to User App Main Screen
        ProductInventory productInventory = productDeliverySystem.getInventory(wareHouse);
        Product productToBuy = null;
        for(Map.Entry<Product, Integer>  productIntegerEntry : productInventory.getProductInventory().entrySet()) {
            if(productIntegerEntry.getKey().getProductName().equals("Earpods") && productIntegerEntry.getValue() > 0) {
                productToBuy = productIntegerEntry.getKey();
            }
        }

        System.out.println("Product Selected" + productToBuy.getProductId() + " " + productToBuy.getProductDescription());

//        4. Add Products to Cart which user wants
        if(productToBuy != null) {
            System.out.println("Product Added to Cart");
            productDeliverySystem.addProductToUserCart(user, productToBuy);
        }
        else {
            System.out.println("Product Not in Stock");
            return;
        }
//        5. Checkout Cart
        System.out.println("Checking Out");
        System.out.println("Creating Order");
        Order order = productDeliverySystem.placeOrder(user, wareHouse);
        System.out.println("Order Created - " + order);
        productDeliverySystem.checkout(order, new UPIPaymentMethod());
    }

    private static List<WareHouse> createWareHouseList() {
        ProductInventory productInventoryW1 = new ProductInventory();
        ProductInventory productInventoryW2 = new ProductInventory();

        Product apples = new Product("P1", "Apples", "RED RED APPLES" ,  ProductCategory.FRUIT);
        Product earphone = new Product("P2", "Earpods", "Apple Earpods" ,  ProductCategory.ELECTRONICS);

        productInventoryW1.addProduct(apples, 5);
        productInventoryW1.addProduct(earphone, 2);

        productInventoryW2.addProduct(apples, 10);
        productInventoryW2.addProduct(earphone, 10);

        WareHouse wareHouse1 = new WareHouse(productInventoryW1);
        WareHouse wareHouse2 = new WareHouse(productInventoryW2);

        return Arrays.asList(wareHouse1, wareHouse2);
    }

    private static List<User> createUserList() {

        User user = new User("124", "Yash", "HSR", new Cart(), new ArrayList<>());
        return Arrays.asList(user);

    }
}

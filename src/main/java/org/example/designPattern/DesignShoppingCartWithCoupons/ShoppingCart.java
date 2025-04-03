package org.example.designPattern.DesignShoppingCartWithCoupons;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    List<Product> productList;

    public ShoppingCart() {
        productList = new ArrayList<>();
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    public void applyCouponAndGetTotalAmount() {
        int totalAmount = 0;
        int originalAmount = 0;

        for(Product product : productList) {
            int amount = new TypeBasedCouponDecorator(new PercentageCouponDecorator(product, 0), 10, product.getProductType()).getPrice();
            totalAmount+=amount;
            originalAmount+= product.getPrice();
        }

        System.out.println("Total Cart Amount = " + originalAmount);
        System.out.println("Total Cart Value After Discount = " + totalAmount);
    }
}

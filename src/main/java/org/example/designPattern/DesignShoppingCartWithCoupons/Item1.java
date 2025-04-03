package org.example.designPattern.DesignShoppingCartWithCoupons;

public class Item1 extends Product{
    public Item1(String name, ProductType productType, int totalAmount) {
        super(name, productType, totalAmount);
    }

    @Override
    public int getPrice() {
        return totalAmount;
    }
}

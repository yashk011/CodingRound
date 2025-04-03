package org.example.designPattern.DesignShoppingCartWithCoupons;

public class Item2 extends Product{
    public Item2(String name, ProductType productType, int totalAmount) {
        super(name, productType, totalAmount);
    }

    @Override
    public int getPrice() {
        return totalAmount;
    }
}

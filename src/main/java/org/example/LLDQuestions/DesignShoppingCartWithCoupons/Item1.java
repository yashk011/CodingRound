package org.example.LLDQuestions.DesignShoppingCartWithCoupons;

public class Item1 extends Product{
    public Item1(String name, ProductType productType, int totalAmount) {
        super(name, productType, totalAmount);
    }

    @Override
    public int getPrice() {
        return totalAmount;
    }
}

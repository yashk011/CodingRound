package org.example.LLDQuestions.DesignShoppingCartWithCoupons;

public abstract class Product {
    String name;
    ProductType productType;
    int totalAmount;

    public Product() {
    }

    public Product(String name, ProductType productType, int totalAmount) {
        this.name = name;
        this.productType = productType;
        this.totalAmount = totalAmount;
    }

    public ProductType getProductType() {
        return this.productType;
    }

    public abstract int getPrice();
}

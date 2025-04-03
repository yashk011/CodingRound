package org.example.designPattern.DesignShoppingCartWithCoupons;

public class PercentageCouponDecorator extends CouponDecorator{
    Product product;
    int discountPercentage;

    public PercentageCouponDecorator(Product product , int discountPercentage) {
        this.product = product;
        this.discountPercentage = discountPercentage;
    }

    @Override
    public int getPrice() {
        int currPrice = product.getPrice();
        System.out.println(discountPercentage);
        int discountedPrice = currPrice - (int) (discountPercentage*currPrice)/100;
        return discountedPrice;
    }
}

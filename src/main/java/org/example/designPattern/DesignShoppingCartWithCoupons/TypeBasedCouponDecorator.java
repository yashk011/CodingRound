package org.example.designPattern.DesignShoppingCartWithCoupons;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TypeBasedCouponDecorator extends CouponDecorator{
    int discountPercentage;

    List<ProductType> discountEligibleProducts = Arrays.asList(ProductType.ELECTRONICS);
    Product product;
    ProductType productType;

    public TypeBasedCouponDecorator(Product product , int discountPercentage, ProductType productType) {
        this.discountPercentage = discountPercentage;
        this.product = product;
        this.productType = productType;
    }
    @Override
    public int getPrice() {
        if(discountEligibleProducts.contains(productType)) {
            int currPrice = product.getPrice();
            System.out.println(discountPercentage);
            int discountedPrice = currPrice - (int) (discountPercentage*currPrice)/100;
            return discountedPrice;
        }
        return  product.getPrice();
    }
}

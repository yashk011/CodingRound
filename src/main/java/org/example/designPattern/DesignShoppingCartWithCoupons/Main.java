package org.example.designPattern.DesignShoppingCartWithCoupons;

public class Main {
    public static void main(String[] args) {
        Item1 item1 = new Item1("Iphone" , ProductType.ELECTRONICS, 100);
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addProduct(item1);

        Item2 item2 = new Item2("Sofa" , ProductType.FURNITURE, 100);
        shoppingCart.addProduct(item2);

        shoppingCart.applyCouponAndGetTotalAmount();

    }
}

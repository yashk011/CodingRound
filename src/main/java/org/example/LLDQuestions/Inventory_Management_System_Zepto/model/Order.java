package org.example.LLDQuestions.Inventory_Management_System_Zepto.model;

import java.util.HashMap;

public class Order {
    String orderId;
    HashMap<Product, Integer> productVsQuantity = new HashMap<>();
    User user;
    Invoice invoice;
    boolean orderStatus;
    Payment payment;
    WareHouse fulfilemtWarehouse;

    public Order(User user, WareHouse wareHouse) {
        this.orderId = "O-123";
        this.productVsQuantity = user.getCart().productVsQuantity;
        this.user = user;
        this.invoice = new Invoice();
        this.fulfilemtWarehouse = wareHouse;
    }

    public void checkout(PaymentMethod paymentMethod) {
//        1. Update Warehouse Inventory
        System.out.println("Quantity Updated in Inventory");
        fulfilemtWarehouse.updateItemFromInventory(productVsQuantity, false);

//        2. Make Payment
        boolean isPaid = makePayment(paymentMethod);
//        3.
//            3.1 Empty Cart
//            3.2 Revert Back on Payment Failure

        if (isPaid) {
            System.out.println("Payment Successful ");
            System.out.println("Emptying Cart");
            this.user.cart = null;
        } else {
            System.out.println("Payment Failure ");
            System.out.println("Quantity Reverted in Inventory");
            fulfilemtWarehouse.updateItemFromInventory(productVsQuantity, true);
        }
    }

    private boolean makePayment(PaymentMethod paymentMethod) {
        payment = new Payment(paymentMethod);
        return payment.makePayment(100);
    }
}

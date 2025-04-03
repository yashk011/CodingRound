package org.example.designPattern.Inventory_Management_System_Zepto.model;

public class CardPaymentMethod implements PaymentMethod{
    @Override
    public boolean payAmount(int amount) {
        return false;
    }
}

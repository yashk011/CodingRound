package org.example.designPattern.Inventory_Management_System_Zepto.model;

public class UPIPaymentMethod implements PaymentMethod{
    @Override
    public boolean payAmount(int amount) {
        System.out.println("Amount Paid " + amount);
        return false;
    }
}

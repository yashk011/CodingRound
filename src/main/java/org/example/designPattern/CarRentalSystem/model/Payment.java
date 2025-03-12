package org.example.designPattern.CarRentalSystem.model;

public class Payment {
    Bill bill;

    public Payment(Bill bill) {
        this.bill = bill;
    }

    public void payBill() {
        System.out.println("Bill Paid");
    }
}

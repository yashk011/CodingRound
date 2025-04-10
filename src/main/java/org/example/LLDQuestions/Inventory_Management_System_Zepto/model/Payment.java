package org.example.LLDQuestions.Inventory_Management_System_Zepto.model;

public class Payment {
    PaymentMethod paymentMethod;

    public Payment(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public boolean makePayment(int amount) {
        return paymentMethod.payAmount(amount);
    }
}

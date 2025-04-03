package org.example.designPattern.Inventory_Management_System_Zepto.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

public class Invoice {
    String invoiceId;
    int totalAmount;
    int totalTax;

    public Invoice() {
        this.invoiceId = "ID1";
        this.totalAmount = 100;
        this.totalTax = 20;
    }
}

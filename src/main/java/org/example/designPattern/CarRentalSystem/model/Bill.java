package org.example.designPattern.CarRentalSystem.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Bill {
    int amount;
    boolean isPaid;
    Reservation reservation;

    public Bill(boolean isPaid, Reservation reservation) {
        this.isPaid = isPaid;
        this.reservation = reservation;
    }

    public int computeBillAmount() {
        this.amount = 100; // Calculate amount using reservation
        return 100;
    }
}

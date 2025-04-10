package org.example.LLDQuestions.lockermanagementsystem.model;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@AllArgsConstructor
@Getter
public class Slot {
    String id;
    Size size;
    LockerItem lockerItem;
    Date allocatedDate;

    public void deallocateSlot() {
        this.lockerItem = null;
    }

    public void allocateSlot(LockerItem lockerItem) {
        this.lockerItem = lockerItem;
        this.allocatedDate = new Date();
    }

    public boolean isAvailable() {
        return this.lockerItem == null;
    }
}

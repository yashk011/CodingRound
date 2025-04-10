package org.example.LLDQuestions.lockermanagementsystem.model;

import java.util.ArrayList;
import java.util.List;


public class Locker {
    String lockerId;
    List<Slot> slots;

    public Locker(String lockerId) {
        this.lockerId = lockerId;
        this.slots = new ArrayList<>();
    }

    public void addSlot(Slot slot) {
        this.slots.add(slot);
    }

    public List<Slot> getAvailableSlot() {
        List<Slot> availableSlots = new ArrayList<>();

        for(Slot slot : slots) {
            if(slot.isAvailable()) {
                availableSlots.add(slot);
            }
        }

        return availableSlots;
    }
}

package org.example.LLDQuestions.lockermanagementsystem.respository;

import org.example.lockermanagementsystem.model.Locker;
import org.example.lockermanagementsystem.model.Slot;

import java.util.ArrayList;
import java.util.List;

public class LockerRepository {
    List<Locker> lockerList;

    public LockerRepository() {
        lockerList = new ArrayList<>();
    }

    public Locker addLocker(String lockerId) {
        Locker locker = new Locker(lockerId);
        lockerList.add(locker);
        return locker;
    }

    public List<Slot> getAllAvailableSlots() {
        List<Slot> slots = new ArrayList<>();
        for(Locker locker : lockerList) {
            slots.addAll(locker.getAvailableSlot());
        }

        return slots;
    }


}

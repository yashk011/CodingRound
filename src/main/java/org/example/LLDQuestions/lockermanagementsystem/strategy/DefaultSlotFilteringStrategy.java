package org.example.LLDQuestions.lockermanagementsystem.strategy;

import org.example.lockermanagementsystem.model.LockerItem;
import org.example.lockermanagementsystem.model.Slot;

import java.util.List;
import java.util.stream.Collectors;

public class DefaultSlotFilteringStrategy implements SlotFilteringStrategy{
    @Override
    public List<Slot> filterSlots(List<Slot> slots, LockerItem lockerItem) {

        return slots.stream()
                .filter(slot -> slot.getSize().equals(lockerItem.getSize()))
                .collect(Collectors.toUnmodifiableList());

//        return slots;
    }
}

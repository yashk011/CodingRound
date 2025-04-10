package org.example.LLDQuestions.lockermanagementsystem.strategy;

import org.example.lockermanagementsystem.model.LockerItem;
import org.example.lockermanagementsystem.model.Slot;

import java.util.List;

public interface SlotFilteringStrategy {

    public List<Slot> filterSlots(List<Slot> slots, LockerItem lockerItem);
}

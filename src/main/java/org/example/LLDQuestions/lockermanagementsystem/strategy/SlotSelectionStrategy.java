package org.example.LLDQuestions.lockermanagementsystem.strategy;

import org.example.lockermanagementsystem.model.Slot;

import java.util.List;

public interface SlotSelectionStrategy {

    public Slot getSlot(List<Slot> slots);
}

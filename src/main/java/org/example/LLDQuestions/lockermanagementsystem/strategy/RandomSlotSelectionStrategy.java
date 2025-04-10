package org.example.LLDQuestions.lockermanagementsystem.strategy;

import org.example.lockermanagementsystem.model.Slot;

import java.util.List;

public class RandomSlotSelectionStrategy implements SlotSelectionStrategy{

    IRandomNumberGenerator randomNumberGenerator;

    public RandomSlotSelectionStrategy(IRandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }
    @Override
    public Slot getSlot(List<Slot> slots) {
        int randomNumber = randomNumberGenerator.generateRandomNumber(slots.size());
        return slots.get(randomNumber);
//        return slots.get(0);
    }
}

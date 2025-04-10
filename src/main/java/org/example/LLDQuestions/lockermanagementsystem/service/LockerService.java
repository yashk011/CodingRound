package org.example.LLDQuestions.lockermanagementsystem.service;

import jakarta.annotation.Nonnull;
import lombok.SneakyThrows;
import org.example.lockermanagementsystem.model.Locker;
import org.example.lockermanagementsystem.model.LockerItem;
import org.example.lockermanagementsystem.model.Size;
import org.example.lockermanagementsystem.model.Slot;
import org.example.lockermanagementsystem.respository.LockerRepository;
import org.example.lockermanagementsystem.strategy.SlotFilteringStrategy;
import org.example.lockermanagementsystem.strategy.SlotSelectionStrategy;

import java.util.List;
import java.util.UUID;

public class LockerService {
    LockerRepository lockerRepository;
    SlotFilteringStrategy slotFilteringStrategy;
    SlotSelectionStrategy slotSelectionStrategy;


    public LockerService(LockerRepository lockerRepository, SlotFilteringStrategy slotFilteringStrategy, SlotSelectionStrategy slotSelectionStrategy) {
        this.lockerRepository = lockerRepository;
        this.slotSelectionStrategy = slotSelectionStrategy;
        this.slotFilteringStrategy = slotFilteringStrategy;
    }

    public Locker createLocker(@Nonnull final String lockerId) {
        return lockerRepository.addLocker(lockerId);
    }

    public Slot addSlot(@Nonnull Locker locker, @Nonnull Size size) {
        Slot slot = new Slot(UUID.randomUUID().toString(), size, null, null);
        locker.addSlot(slot);
        return slot;
    }

    public List<Slot> getAvailableSlot() {
        return lockerRepository.getAllAvailableSlots();
    }

    public void deallocateSlot(@Nonnull final Slot slot) {
        slot.deallocateSlot();
    }

    @SneakyThrows
    public Slot allocateSlot(@Nonnull LockerItem lockerItem) {
        List<Slot> slots = lockerRepository.getAllAvailableSlots();
        List<Slot> filteredSlots = slotFilteringStrategy.filterSlots(slots, lockerItem);
        Slot selectedSlot = slotSelectionStrategy.getSlot(filteredSlots);

        if(selectedSlot == null)
            throw new Exception("Slot could not be allocated");

        selectedSlot.allocateSlot(lockerItem);
        return selectedSlot;
    }
}

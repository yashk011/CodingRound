package org.example.LLDQuestions.lockermanagementsystem.controller;

import jakarta.annotation.Nonnull;
import org.example.lockermanagementsystem.model.Locker;
import org.example.lockermanagementsystem.model.Size;
import org.example.lockermanagementsystem.model.Slot;
import org.example.lockermanagementsystem.service.LockerService;
import org.example.lockermanagementsystem.service.OtpService;

import java.util.List;

/* Java class to expose APIs to -
    a. Create Lockers
    b. Create Slots
    c. Allocate Lockers
    d. Deallocate Lockers
    e. List all available Lockers
 */
public class LockerController {
    LockerService lockerService;
    OtpService otpService;

    public LockerController(LockerService lockerService, OtpService otpService) {
        this.lockerService = lockerService;
        this.otpService = otpService;
    }

    public Locker createLocker(@Nonnull final String lockerId) {
        Locker locker = lockerService.createLocker(lockerId);
        return locker;
    }

    public Slot addSlotToLocker(@Nonnull final Locker locker , @Nonnull final Size slotSize) {
        Slot slot = lockerService.addSlot(locker, slotSize);
        return slot;
    }

    public List<Slot> getAllAvailableSlots() {
        return lockerService.getAvailableSlot();
    }

    public boolean unLockSlot(@Nonnull final Slot slot, @Nonnull final String otp) {
        return otpService.validateOtp(slot, otp);
    }
    public void deAllocateSlot(@Nonnull final Slot slot) {
        lockerService.deallocateSlot(slot);
    }

}

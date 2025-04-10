package LockerSystem;

import org.example.lockermanagementsystem.model.*;
import org.example.lockermanagementsystem.model.Package;
import org.junit.jupiter.api.Test;

import java.util.List;

public class OrdersTest extends BaseTest{

    @Test
    public void validateOtp() {
        Locker locker1 = lockerController.createLocker("Locker - 1");
        Slot slot1 = lockerController.addSlotToLocker(locker1, Size.LARGE);
        Slot slot3 = lockerController.addSlotToLocker(locker1, Size.LARGE);
        Slot slot4 = lockerController.addSlotToLocker(locker1, Size.LARGE);

        Slot slot2 = lockerController.addSlotToLocker(locker1, Size.MEDIUM);
        PackageOwner packageOwner1 = new PackageOwner(new Contact("Yash" , "6232076707"));
        org.example.lockermanagementsystem.model.Package lockerItem1 = new org.example.lockermanagementsystem.model.Package("USB Cable", Size.LARGE);
        org.example.lockermanagementsystem.model.Package lockerItem2 = new Package("Tshirt", Size.LARGE);

        List<Slot> slotList = lockerController.getAllAvailableSlots();
        System.out.println("== Available Slots ==");
        for(Slot slot : slotList) {
            System.out.println(slot.getId() + " " + slot.getLockerItem());
        }

        System.out.println("== Allocating Locker to User - " + packageOwner1.getContact().getName());
        Slot allocatedSlot = ordersController.allocateLockerToUser(packageOwner1, lockerItem1);
        System.out.println("Allocated slot - " + allocatedSlot.getId() + " to User " + packageOwner1.getContact().getName());

        System.out.println("=== Opening Locker ==== ");
        boolean isUnlocked = lockerController.unLockSlot(allocatedSlot, "1243");
        if(isUnlocked)
            System.out.println("=== Locker Unlocked === ");
        else
            System.out.println("!!! Wrong OTP !!!");

        System.out.println("=== Deallocating Locker === ");
        lockerController.deAllocateSlot(slot1);
    }
}

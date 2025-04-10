package LockerSystem;

import LockerSystem.utils.LockerUtils;
import LockerSystem.utils.PackageOwnerUtils;
import org.example.lockermanagementsystem.model.*;
import org.example.lockermanagementsystem.model.Package;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LockerSystemTest extends BaseTest{

    @Test
    public void testSlotAllocationUser() {
        Locker locker1 = lockerController.createLocker("Locker - 1");
        Slot slot1 = lockerController.addSlotToLocker(locker1, Size.LARGE);
        Slot slot2 = lockerController.addSlotToLocker(locker1, Size.MEDIUM);
        PackageOwner packageOwner1 = new PackageOwner(new Contact("Yash" , "6232076707"));
        Package lockerItem1 = new Package("USB Cable", Size.LARGE);
        Package lockerItem2 = new Package("Tshirt", Size.MEDIUM);

        List<Slot> slotList = lockerController.getAllAvailableSlots();
        System.out.println("== Available Slots ==");
        for(Slot slot : slotList) {
            System.out.println(slot.getId() + " " + slot.getLockerItem());
        }

        System.out.println("== Allocating Locker to User - " + packageOwner1.getContact().getName());
        Slot allocatedSlot = ordersController.allocateLockerToUser(packageOwner1, lockerItem1);
        System.out.println("Allocated slot - " + allocatedSlot.getId() + " to User " + packageOwner1.getContact().getName());

        System.out.println("== Available Slots ==");
        List<Slot> slotList2 = lockerController.getAllAvailableSlots();
        for(Slot slot : slotList2) {
            System.out.println(slot.getId() + " " + slot.getLockerItem());
        }

        System.out.println("== Allocating Locker to User - " + packageOwner1.getContact().getName());
        Slot allocatedSlot2 = ordersController.allocateLockerToUser(packageOwner1, lockerItem2);
        System.out.println("Allocated slot - " + allocatedSlot2.getId() + " to User " + packageOwner1.getContact().getName());

    }

    @Test
    public void testSlotAllocation_02() {
        LockerUtils.createLockerWithSlots(lockerController, 2, Size.LARGE);
        LockerUser lockerUser = PackageOwnerUtils.getRandomLockerUser(new Contact("Yashika" ,"93949834934"));
        List<Slot> availableSlots = lockerController.getAllAvailableSlots();
        LockerItem lockerItem1 = LockerUtils.createRandomPackage(Size.LARGE);
        LockerItem lockerItem2 = LockerUtils.createRandomPackage(Size.LARGE);
        Slot slot1 = ordersController.allocateLockerToUser(lockerUser, lockerItem1);

        Assertions.assertFalse(lockerController.unLockSlot(slot1,"12222"));

        List<Slot> availableSlots2 = lockerController.getAllAvailableSlots();
        Assertions.assertFalse(availableSlots2.contains(slot1));

        lockerController.deAllocateSlot(slot1);
        List<Slot> availableSlots3 = lockerController.getAllAvailableSlots();

        Assertions.assertTrue(availableSlots3.contains(slot1));
    }
}

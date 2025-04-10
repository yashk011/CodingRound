package LockerSystem.utils;

import org.example.lockermanagementsystem.controller.LockerController;
import org.example.lockermanagementsystem.model.*;

import java.util.Random;

public class LockerUtils {

    public static Locker createLockerWithSlots(LockerController lockerController, int slots, Size size) {
        final Locker locker = lockerController.createLocker("Utility Locker 1");
        for(int i=0;i<slots;i++) {
            Slot slot = lockerController.addSlotToLocker(locker, size);
        }

        return locker;
    }

    public static LockerItem createRandomPackage(Size size) {
        return new Package(new Random().toString(), size);
    }
}

package org.example.LLDQuestions.lockermanagementsystem.controller;

/*
     Java Class to allocate -
        a. Allocate Locker to User
 */

import jakarta.annotation.Nonnull;
import org.example.lockermanagementsystem.model.LockerItem;
import org.example.lockermanagementsystem.model.LockerUser;
import org.example.lockermanagementsystem.model.PackageOwner;
import org.example.lockermanagementsystem.model.Slot;
import org.example.lockermanagementsystem.service.LockerService;
import org.example.lockermanagementsystem.service.NotificationService;
import org.example.lockermanagementsystem.service.OtpService;

public class OrdersController {
    LockerService lockerService;
    OtpService otpService;
    NotificationService notificationService;

    public OrdersController(LockerService lockerService, OtpService otpService, NotificationService notificationService) {
        this.lockerService = lockerService;
        this.otpService = otpService;
        this.notificationService = notificationService;
    }
    public Slot allocateLockerToUser(@Nonnull final LockerUser packageOwner, @Nonnull LockerItem lockerItem) {
        Slot slot = lockerService.allocateSlot(lockerItem);
        String otp = otpService.generateOtp(slot);
        // Send Notification to Product Owner Via Notification Service
        notificationService.sendNotification(packageOwner, slot, otp);
        return slot;
    }
}

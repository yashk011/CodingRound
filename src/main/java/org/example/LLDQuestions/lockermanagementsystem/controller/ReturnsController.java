package org.example.LLDQuestions.lockermanagementsystem.controller;

import jakarta.annotation.Nonnull;
import org.example.lockermanagementsystem.model.DeliveryGuy;
import org.example.lockermanagementsystem.model.LockerItem;
import org.example.lockermanagementsystem.model.Slot;
import org.example.lockermanagementsystem.service.DeliveryPersonService;
import org.example.lockermanagementsystem.service.LockerService;
import org.example.lockermanagementsystem.service.NotificationService;
import org.example.lockermanagementsystem.service.OtpService;

public class ReturnsController {
    OtpService otpService;
    NotificationService notificationService;
    DeliveryPersonService deliveryPersonService;
    LockerService lockerService;

    public ReturnsController(LockerService lockerService, OtpService otpService, NotificationService notificationService, DeliveryPersonService deliveryPersonService) {
        this.lockerService = lockerService;
        this.otpService = otpService;
        this.notificationService = notificationService;
        this.deliveryPersonService = deliveryPersonService;
    }

    public void allocateLockerToDeliveryGuy(@Nonnull final LockerItem lockerItem) {
        Slot slot = lockerService.allocateSlot(lockerItem);
        String otp = otpService.generateOtp(slot);
        DeliveryGuy deliveryGuy = deliveryPersonService.getDeliveryGuy();
        notificationService.sendNotification(deliveryGuy, slot, otp);
    }
}

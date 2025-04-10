package org.example.LLDQuestions.lockermanagementsystem.service;

import org.example.lockermanagementsystem.model.LockerUser;
import org.example.lockermanagementsystem.model.Slot;

public class NotificationService {

    public void sendNotification(LockerUser lockerUser, Slot allocatedSlot, String otp) {
        System.out.println("Msg sent to - " + lockerUser.getContact().getPhoneNumber() + " Slot - " + allocatedSlot.getId() + " OTP - " + otp);
    }
}

package org.example.LLDQuestions.lockermanagementsystem.service;

import org.example.lockermanagementsystem.model.Slot;
import org.example.lockermanagementsystem.respository.SlotOtpRepository;
import org.example.lockermanagementsystem.strategy.IOtpGenerator;

public class OtpService {

    SlotOtpRepository slotOtpRepository;
    IOtpGenerator otpGenerator;
    public OtpService(SlotOtpRepository slotOtpRepository, IOtpGenerator otpGenerator) {
        this.slotOtpRepository = slotOtpRepository;
        this.otpGenerator = otpGenerator;
    }
    public boolean validateOtp(Slot slot, String otp) {
        String savedOtp = slotOtpRepository.getSlotOtp(slot.getId());
        return (savedOtp == null || savedOtp != otp ) ? false : true;
    }

    public String generateOtp(Slot slot) {
        String newOtp = otpGenerator.generateOtp();
        slotOtpRepository.setSlotOtp(slot.getId(), newOtp);
        return newOtp;
    }


}

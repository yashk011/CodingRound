package org.example.LLDQuestions.lockermanagementsystem.respository;

import java.util.HashMap;
import java.util.Map;

public class SlotOtpRepository {
    Map<String, String> slotOtpDB;

    public SlotOtpRepository() {
        slotOtpDB = new HashMap<>();
    }

    public void setSlotOtp(String slotId, String newOtp) {
        slotOtpDB.put(slotId, newOtp);
    }

    public String getSlotOtp(String slotId) {
        return slotOtpDB.get(slotId);
    }
}

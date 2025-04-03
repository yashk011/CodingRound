package org.example.designPattern.PaymentGateway.service;

import org.example.designPattern.PaymentGateway.dto.InstrumentDTO;
import org.example.designPattern.PaymentGateway.model.Transaction;

public class Processor {
    public boolean checkRequiredBalance(InstrumentDTO senderInstrumentDetails, String amount) {
        return true;
    }

    public boolean isAccountValid(InstrumentDTO receiverInstrumentDetails) {
        return true;
    }

    public boolean makePayment(Transaction transaction) {
        return true;
    }
}

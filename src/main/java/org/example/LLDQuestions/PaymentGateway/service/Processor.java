package org.example.LLDQuestions.PaymentGateway.service;

import org.example.LLDQuestions.PaymentGateway.dto.InstrumentDTO;
import org.example.LLDQuestions.PaymentGateway.model.Transaction;

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

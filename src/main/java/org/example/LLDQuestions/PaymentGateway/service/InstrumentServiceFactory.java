package org.example.LLDQuestions.PaymentGateway.service;

import org.example.LLDQuestions.PaymentGateway.model.InstrumentType;

public class InstrumentServiceFactory {

    static InstrumentService cardInstrumentService;
    static InstrumentService bankInstrumentService;

    public static InstrumentService getInstrumentService(InstrumentType instrumentType) {
        if(instrumentType.name().equalsIgnoreCase("CARD")) {
            if(cardInstrumentService != null) return cardInstrumentService;
            else {
                cardInstrumentService = new CardInstrumentService();
                return cardInstrumentService;
            }
        }
        if(instrumentType.name().equalsIgnoreCase("BANK_ACCOUNT")) {
            if(bankInstrumentService != null) return bankInstrumentService;
            else {
                bankInstrumentService = new BankInstrumentService();
                return bankInstrumentService;
            }
        }
        return null;
    }
}

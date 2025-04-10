package org.example.LLDQuestions.PaymentGateway.service;

import org.example.LLDQuestions.PaymentGateway.dto.InstrumentDTO;
import org.example.LLDQuestions.PaymentGateway.model.CreditCardInstrument;
import org.example.LLDQuestions.PaymentGateway.model.Instrument;
import org.example.LLDQuestions.PaymentGateway.model.InstrumentType;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class CardInstrumentService extends InstrumentService{
    @Override
    public String addInstrument(InstrumentDTO instrumentDTO) {

        CreditCardInstrument creditCardInstrument = new CreditCardInstrument();
        String instrumentId = "I-" +UUID.randomUUID().toString();

        creditCardInstrument.setInstrumentId(instrumentId);
        creditCardInstrument.setUserId(instrumentDTO.getUserId());
        creditCardInstrument.setInstrumentType(InstrumentType.CARD);
        creditCardInstrument.setCreditCardNumber(instrumentDTO.getCreditCardNumber());
        creditCardInstrument.setCVV(instrumentDTO.getCVV());

        String userId = instrumentDTO.getUserId();
        List<Instrument> creditCardInstrumentList = instrumentList.getOrDefault(userId, new ArrayList<>());
        creditCardInstrumentList.add(creditCardInstrument);

        instrumentList.put(userId, creditCardInstrumentList);
        return instrumentId;
    }

    @Override
    public List<InstrumentDTO> getAllInstrument(String userId) {
        return convertInstrumentToDTO(instrumentList.get(userId));
    }

    private List<InstrumentDTO> convertInstrumentToDTO(List<Instrument> instruments) {
        List<InstrumentDTO> instrumentDTOs = instruments.stream()
                .filter(instrument -> instrument instanceof CreditCardInstrument) // Ensure it's a BankInstrument
                .map(instrument -> {
                    CreditCardInstrument creditCardInstrument = (CreditCardInstrument) instrument;
                    InstrumentDTO instrumentDTO = new InstrumentDTO();
                    instrumentDTO.setInstrumentId(creditCardInstrument.getInstrumentId());
                    instrumentDTO.setInstrumentType(creditCardInstrument.getInstrumentType());
                    instrumentDTO.setCVV(creditCardInstrument.getCVV());
                    instrumentDTO.setUserId(creditCardInstrument.getUserId());
                    instrumentDTO.setCreditCardNumber(creditCardInstrument.getCreditCardNumber());
                    return instrumentDTO;
                })
                .collect(Collectors.toList()); // Collect into a list

        return instrumentDTOs;
    }

}

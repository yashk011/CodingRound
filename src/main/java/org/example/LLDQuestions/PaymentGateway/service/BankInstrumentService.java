package org.example.LLDQuestions.PaymentGateway.service;

import org.example.LLDQuestions.PaymentGateway.dto.InstrumentDTO;
import org.example.LLDQuestions.PaymentGateway.model.BankInstrument;
import org.example.LLDQuestions.PaymentGateway.model.Instrument;
import org.example.LLDQuestions.PaymentGateway.model.InstrumentType;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class BankInstrumentService extends InstrumentService{
    @Override
    public String addInstrument(InstrumentDTO instrumentDTO) {

        BankInstrument bankInstrument = new BankInstrument();
        String instrumentId = "I-" +UUID.randomUUID().toString();

        bankInstrument.setInstrumentId(instrumentId);
        bankInstrument.setUserId(instrumentDTO.getUserId());
        bankInstrument.setInstrumentType(InstrumentType.BANK_ACCOUNT);
        bankInstrument.setBankAccountNumber(instrumentDTO.getBankAccountNumber());
        bankInstrument.setIFSCCode(instrumentDTO.getIFSCCode());

        String userId = instrumentDTO.getUserId();
        List<Instrument> bankInstrumentList = instrumentList.getOrDefault(userId, new ArrayList<>());
        bankInstrumentList.add(bankInstrument);

        instrumentList.put(userId, bankInstrumentList);

        return instrumentId;
    }

    @Override
    public List<InstrumentDTO> getAllInstrument(String userId) {
        return convertInstrumentToDTO(instrumentList.get(userId));
    }

    private List<InstrumentDTO> convertInstrumentToDTO(List<Instrument> instruments) {
        if(instruments == null) return null;

        List<InstrumentDTO> instrumentDTOs = instruments.stream()
                .filter(instrument -> instrument instanceof BankInstrument) // Ensure it's a BankInstrument
                .map(instrument -> {
                    BankInstrument bankInstrument = (BankInstrument) instrument;
                    InstrumentDTO instrumentDTO = new InstrumentDTO();
                    instrumentDTO.setInstrumentId(bankInstrument.getInstrumentId());
                    instrumentDTO.setInstrumentType(bankInstrument.getInstrumentType());
                    instrumentDTO.setIFSCCode(bankInstrument.getIFSCCode());
                    instrumentDTO.setUserId(bankInstrument.getUserId());
                    instrumentDTO.setBankAccountNumber(bankInstrument.getBankAccountNumber());
                    return instrumentDTO;
                })
                .collect(Collectors.toList()); // Collect into a list

        return instrumentDTOs;
    }

}

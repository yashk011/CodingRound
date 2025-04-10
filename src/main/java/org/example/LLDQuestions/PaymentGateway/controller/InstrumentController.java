package org.example.LLDQuestions.PaymentGateway.controller;

import org.example.LLDQuestions.PaymentGateway.dto.InstrumentDTO;
import org.example.LLDQuestions.PaymentGateway.model.InstrumentType;
import org.example.LLDQuestions.PaymentGateway.service.InstrumentService;
import org.example.LLDQuestions.PaymentGateway.service.InstrumentServiceFactory;

import java.util.List;

public class InstrumentController {


    public InstrumentController() {
    }

    public String addInstrument(InstrumentDTO instrumentDTO) {
        InstrumentService instrumentService = InstrumentServiceFactory.getInstrumentService(instrumentDTO.getInstrumentType());
        return instrumentService.addInstrument(instrumentDTO);
    }

    public List<InstrumentDTO> getAllInstrument(String userId) {
        InstrumentService instrumentService1 = InstrumentServiceFactory.getInstrumentService(InstrumentType.BANK_ACCOUNT);
        InstrumentService instrumentService2 = InstrumentServiceFactory.getInstrumentService(InstrumentType.CARD);

        List<InstrumentDTO> instrumentDTO = instrumentService1.getAllInstrument(userId);
        List<InstrumentDTO> instrumentDTO2 = instrumentService2.getAllInstrument(userId);

        if(instrumentDTO != null) {
            instrumentDTO.addAll(instrumentDTO2);
            return instrumentDTO;
        }

        return  instrumentDTO2;
    }

    public InstrumentDTO getInstrumentDetails(String instrumentId, String userId) {
        List<InstrumentDTO> allInstrument = getAllInstrument(userId);
        return allInstrument.stream().filter(instrumentDTO -> instrumentDTO.getInstrumentId().equalsIgnoreCase(instrumentId)).findFirst().get();
    }
}

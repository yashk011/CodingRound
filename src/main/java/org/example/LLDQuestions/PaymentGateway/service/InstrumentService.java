package org.example.LLDQuestions.PaymentGateway.service;

import org.example.LLDQuestions.PaymentGateway.dto.InstrumentDTO;
import org.example.LLDQuestions.PaymentGateway.model.Instrument;

import java.util.HashMap;
import java.util.List;

public abstract class InstrumentService {
    HashMap<String, List<Instrument>> instrumentList = new HashMap<>();

    public abstract String addInstrument(InstrumentDTO instrumentDTO);
    public abstract List<InstrumentDTO> getAllInstrument(String userId);
}

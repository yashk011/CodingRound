package org.example.designPattern.PaymentGateway.service;

import org.example.designPattern.PaymentGateway.dto.InstrumentDTO;
import org.example.designPattern.PaymentGateway.model.Instrument;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class InstrumentService {
    HashMap<String, List<Instrument>> instrumentList = new HashMap<>();

    public abstract String addInstrument(InstrumentDTO instrumentDTO);
    public abstract List<InstrumentDTO> getAllInstrument(String userId);
}

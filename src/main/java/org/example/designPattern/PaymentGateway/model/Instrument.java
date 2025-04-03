package org.example.designPattern.PaymentGateway.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class Instrument {
    String instrumentId;
    String userId;
    InstrumentType instrumentType;

}

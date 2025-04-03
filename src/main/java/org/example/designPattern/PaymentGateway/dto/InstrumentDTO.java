package org.example.designPattern.PaymentGateway.dto;

import lombok.Getter;
import lombok.Setter;
import org.example.designPattern.PaymentGateway.model.InstrumentType;

@Setter
@Getter
public class InstrumentDTO {
    String userId;
    String instrumentId;
    InstrumentType instrumentType;
    String creditCardNumber;
    String CVV;
    String bankAccountNumber;
    String IFSCCode;

    @Override
    public String toString() {
        return "User ID -> " + userId +
                " Instrument ID -> " + instrumentId +
                " Instrument Type -> "  + instrumentType;
    }

}

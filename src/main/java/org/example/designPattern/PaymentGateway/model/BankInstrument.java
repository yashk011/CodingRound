package org.example.designPattern.PaymentGateway.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class BankInstrument extends Instrument{
    String bankAccountNumber;
    String IFSCCode;
}

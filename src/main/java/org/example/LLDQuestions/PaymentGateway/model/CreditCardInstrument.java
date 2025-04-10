package org.example.LLDQuestions.PaymentGateway.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CreditCardInstrument extends Instrument{
    String creditCardNumber;
    String CVV;
}

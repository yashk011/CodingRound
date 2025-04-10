package org.example.LLDQuestions.PaymentGateway.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class TransactionDTO {
    String senderUserId;
    String receiverUserId;
    String debitInstrumentId;
    String creditInstrumentId;
    String amount;
}

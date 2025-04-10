package org.example.LLDQuestions.PaymentGateway.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.LLDQuestions.PaymentGateway.service.TransactionStatus;

@AllArgsConstructor
@Setter
@NoArgsConstructor
@Getter
public class Transaction {
    String transactionId;
    String senderUserId;
    String receiverUserId;
    String debitInstrumentId;
    String creditInstrumentId;
    String amount;
    TransactionStatus status;

    @Override
    public String toString() {
        return "Transaction ID -> " + transactionId +
                "\nSender user id -> " + senderUserId +
                "\nReceiver user id -> "  + receiverUserId +
                "\nAmount -> " + amount;
    }

}

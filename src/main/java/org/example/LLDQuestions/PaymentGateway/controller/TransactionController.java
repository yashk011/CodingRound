package org.example.LLDQuestions.PaymentGateway.controller;

import org.example.LLDQuestions.PaymentGateway.dto.TransactionDTO;
import org.example.LLDQuestions.PaymentGateway.model.Transaction;
import org.example.LLDQuestions.PaymentGateway.service.TransactionService;

import java.util.List;

public class TransactionController {
    TransactionService transactionService;
    public TransactionController(InstrumentController instrumentController, UserController userController) {
        transactionService = new TransactionService(instrumentController, userController);
    }

    public String initiateTransaction(TransactionDTO transactionDTO) {
        return transactionService.initiateTransaction(transactionDTO);
    }

    public List<Transaction> getTransactionHistory(String userId) {
        return transactionService.getPaymentHistory(userId);
    }


}

package org.example.designPattern.PaymentGateway.controller;

import org.example.designPattern.PaymentGateway.dto.TransactionDTO;
import org.example.designPattern.PaymentGateway.dto.UserDTO;
import org.example.designPattern.PaymentGateway.model.Transaction;
import org.example.designPattern.PaymentGateway.service.TransactionService;

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

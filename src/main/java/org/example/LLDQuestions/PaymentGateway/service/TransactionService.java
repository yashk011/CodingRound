package org.example.LLDQuestions.PaymentGateway.service;

import org.example.LLDQuestions.PaymentGateway.controller.InstrumentController;
import org.example.LLDQuestions.PaymentGateway.controller.UserController;
import org.example.LLDQuestions.PaymentGateway.dto.InstrumentDTO;
import org.example.LLDQuestions.PaymentGateway.dto.TransactionDTO;
import org.example.LLDQuestions.PaymentGateway.model.Transaction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class TransactionService {
    HashMap<String, List<Transaction>> transactionHistory = new HashMap<>();
    InstrumentController instrumentController;
    Processor processor;

    public TransactionService(InstrumentController instrumentController , UserController userController) {
        this.transactionHistory = new HashMap<>();
        this.instrumentController = instrumentController;
        this.processor = new Processor();
    }

    public String initiateTransaction(TransactionDTO transactionDTO) {
        InstrumentDTO senderInstrumentDetails = instrumentController.getInstrumentDetails(transactionDTO.getDebitInstrumentId(), transactionDTO.getSenderUserId());
        InstrumentDTO receiverInstrumentDetails = instrumentController.getInstrumentDetails(transactionDTO.getCreditInstrumentId(), transactionDTO.getReceiverUserId());

        boolean isSenderHavingBalance = processor.checkRequiredBalance(senderInstrumentDetails, transactionDTO.getAmount());
        boolean isReceiverValid = processor.isAccountValid(receiverInstrumentDetails);
        String id =  UUID.randomUUID().toString();

        if(isReceiverValid && isSenderHavingBalance) {
            Transaction transaction = new Transaction();

            transaction.setTransactionId(id);
            transaction.setAmount(transactionDTO.getAmount());
            transaction.setCreditInstrumentId(receiverInstrumentDetails.getInstrumentId());
            transaction.setDebitInstrumentId(senderInstrumentDetails.getInstrumentId());
            transaction.setSenderUserId(senderInstrumentDetails.getUserId());
            transaction.setReceiverUserId(receiverInstrumentDetails.getUserId());
            transaction.setStatus(TransactionStatus.PENDING);
            boolean status = processor.makePayment(transaction);

            if(status == true) {
                transaction.setStatus(TransactionStatus.SUCCESS);

                String senderId = transactionDTO.getSenderUserId();
                String receiverId = transactionDTO.getReceiverUserId();

                List<Transaction> senderHistory = transactionHistory.getOrDefault(senderId, new ArrayList<>());
                senderHistory.add(transaction);
                transactionHistory.put(senderId, senderHistory);

                List<Transaction> receiverHistory = transactionHistory.getOrDefault(receiverId, new ArrayList<>());
                receiverHistory.add(transaction);
                transactionHistory.put(receiverId, receiverHistory);
            }
        }
        return id;
    }

    public List<Transaction> getPaymentHistory(String user) {

        return transactionHistory.get(user);
//        List<InstrumentDTO> instrumentDTOs = transactionHistory.get(user).stream()
//                .map(transaction -> {
//                    TransactionDTO transactionDTO = new TransactionDTO();
//                    transactionDTO.setAmount(transaction.getAmount());
//                    transactionDTO.setT
//                    return instrumentDTO;
//                })
//                .collect(Collectors.toList()); // Collect into a list

    }
}

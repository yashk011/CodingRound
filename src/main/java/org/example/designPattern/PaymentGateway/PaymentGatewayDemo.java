package org.example.designPattern.PaymentGateway;

import org.example.designPattern.PaymentGateway.controller.InstrumentController;
import org.example.designPattern.PaymentGateway.controller.TransactionController;
import org.example.designPattern.PaymentGateway.controller.UserController;
import org.example.designPattern.PaymentGateway.dto.InstrumentDTO;
import org.example.designPattern.PaymentGateway.dto.TransactionDTO;
import org.example.designPattern.PaymentGateway.dto.UserDTO;
import org.example.designPattern.PaymentGateway.model.InstrumentType;
import org.example.designPattern.PaymentGateway.model.Transaction;
import org.example.designPattern.PaymentGateway.model.User;

import java.util.List;

public class PaymentGatewayDemo {
    public static void main(String[] args) {
        UserController userController = new UserController();
        InstrumentController instrumentController = new InstrumentController();
        TransactionController transactionController = new TransactionController(instrumentController, userController);
        // Create User

        String userId1 = userController.addUser(new UserDTO("Yash", "khu@gmail.com", "123445565"));
        String userId2 = userController.addUser(new UserDTO("Rudra", "rudra@gmail.com", "323445565"));

        UserDTO user1 = userController.getUser(userId1);
        System.out.println(user1.toString());

        // Create Instrument

        InstrumentDTO instrumentDTOBank = new InstrumentDTO();
        instrumentDTOBank.setBankAccountNumber("BOB-123");
        instrumentDTOBank.setIFSCCode("BARBJAGDAL");
        instrumentDTOBank.setUserId(userId1);
        instrumentDTOBank.setInstrumentType(InstrumentType.BANK_ACCOUNT);

        String instrumentId1 = instrumentController.addInstrument(instrumentDTOBank);

        InstrumentDTO instrumentDTOCard = new InstrumentDTO();
        instrumentDTOCard.setCVV("788");
        instrumentDTOCard.setCreditCardNumber("8843383493993");
        instrumentDTOCard.setUserId(userId1);
        instrumentDTOCard.setInstrumentType(InstrumentType.CARD);
        String instrumentId2 = instrumentController.addInstrument(instrumentDTOCard);

        List<InstrumentDTO> instrumentDTOList = instrumentController.getAllInstrument(userId1);
        for(InstrumentDTO instrumentDTO : instrumentDTOList)
            System.out.println(instrumentDTO.toString());


        InstrumentDTO instrumentDTOCard2 = new InstrumentDTO();
        instrumentDTOCard.setCVV("999");
        instrumentDTOCard.setCreditCardNumber("9943383493993");
        instrumentDTOCard.setUserId(userId2);
        instrumentDTOCard.setInstrumentType(InstrumentType.CARD);
        String instrumentId3 = instrumentController.addInstrument(instrumentDTOCard);

        List<InstrumentDTO> instrumentDTOList2 = instrumentController.getAllInstrument(userId2);
        for(InstrumentDTO instrumentDTO : instrumentDTOList2)
            System.out.println(instrumentDTO.toString());

        // Make transaction

        TransactionDTO transactionDTO = new TransactionDTO(userId1, userId2, instrumentId1, instrumentId3, "100");
        String transactionId = transactionController.initiateTransaction(transactionDTO);
//        System.out.println("Transaction - " +  transactionId + " generated");

        TransactionDTO transactionDTO2 = new TransactionDTO(userId2, userId1, instrumentId3, instrumentId1, "200");
        String transactionId2 = transactionController.initiateTransaction(transactionDTO2);
//        System.out.println("Transaction - " +  transactionId + " generated");

        List<Transaction> transactions = transactionController.getTransactionHistory(userId1);

        for(Transaction transaction : transactions) {
            System.out.println(transaction.toString());
        }
    }
}

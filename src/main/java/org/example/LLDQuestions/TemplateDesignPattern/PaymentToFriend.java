package org.example.LLDQuestions.TemplateDesignPattern;

public class PaymentToFriend extends Payment{
    @Override
    public void validateRequest() {
        System.out.println("Checking if Receiver is in you friend list");
    }

    @Override
    public void debitMoney() {
        System.out.println("Debited Amount from Bank ");
    }

    @Override
    public void chargePlatformFeed() {
        System.out.println("0 platform fees");
    }

    @Override
    public void creditMoney() {
        System.out.println("Money sent to frnd");
    }
}

package org.example.designPattern.TemplateDesignPattern;

public class PaymentToMerchant extends Payment{
    @Override
    public void validateRequest() {
        System.out.println("Checking if Receiver is in Spam");
    }

    @Override
    public void debitMoney() {
        System.out.println("Debited Amount from Bank ");
    }

    @Override
    public void chargePlatformFeed() {
        System.out.println("2% platform fees");
    }

    @Override
    public void creditMoney() {
        System.out.println("Money sent to Merchant");
    }
}

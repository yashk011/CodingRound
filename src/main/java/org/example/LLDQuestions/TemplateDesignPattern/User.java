package org.example.LLDQuestions.TemplateDesignPattern;

public class User {
    public static void main(String[] args) {
        Payment obj = new PaymentToFriend();
        Payment obj2 = new PaymentToMerchant();

        obj.sendMoney();
        System.out.println("===========");
        obj2.sendMoney();
    }
}

package org.example.LLDQuestions.TemplateDesignPattern;

public abstract class Payment {
    public  abstract void validateRequest();
    public  abstract void debitMoney();
    public  abstract void chargePlatformFeed();
    public  abstract void creditMoney();

    // None can override this
    public final void sendMoney() {
        validateRequest();;
        debitMoney();
        chargePlatformFeed();
        creditMoney();
    }
}

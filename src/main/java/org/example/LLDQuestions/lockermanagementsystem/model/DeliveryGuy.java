package org.example.LLDQuestions.lockermanagementsystem.model;

import lombok.Getter;

@Getter
public class DeliveryGuy extends LockerUser{

    public DeliveryGuy(Contact contact) {
        super(contact);
    }
}

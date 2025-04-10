package org.example.LLDQuestions.lockermanagementsystem.service;

import org.example.lockermanagementsystem.model.Contact;
import org.example.lockermanagementsystem.model.DeliveryGuy;

public class DeliveryPersonService {

    public DeliveryGuy getDeliveryGuy() {
        return new DeliveryGuy(new Contact("123" , "13343443233"));
    }
}

package org.example.LLDQuestions.PaymentGateway.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserDTO {
    String name;
    String emailAddress;
    String phoneNumber;

    @Override
    public String toString() {
        return " User Name -> " + name +
                " Email ID -> " + emailAddress +
                " Phone Number -> "  + phoneNumber;
    }

}

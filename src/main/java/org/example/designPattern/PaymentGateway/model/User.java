package org.example.designPattern.PaymentGateway.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class User {
    String userId;
    String userName;
    String emailId;
    String phoneNumber;
}

package org.example.LLDQuestions.lockermanagementsystem.model;

import lombok.Getter;

@Getter
public class PackageOwner extends LockerUser{
    public PackageOwner(Contact contact) {
        super(contact);
    }
}

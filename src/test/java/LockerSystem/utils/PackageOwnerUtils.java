package LockerSystem.utils;

import org.example.lockermanagementsystem.model.Contact;
import org.example.lockermanagementsystem.model.LockerUser;
import org.example.lockermanagementsystem.model.PackageOwner;

public class PackageOwnerUtils {
    public static LockerUser getRandomLockerUser(Contact contact) {
        return new PackageOwner(contact);
    }
}

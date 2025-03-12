package org.example.designPattern.VendingMachine;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class VendingMachineShelf {
    VendingMachineItem vendingMachineItem;
    boolean isAvailable;
}

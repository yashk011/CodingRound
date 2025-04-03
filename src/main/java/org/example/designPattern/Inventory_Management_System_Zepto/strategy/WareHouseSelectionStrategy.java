package org.example.designPattern.Inventory_Management_System_Zepto.strategy;

import org.example.designPattern.Inventory_Management_System_Zepto.model.WareHouse;

import java.util.List;

public interface WareHouseSelectionStrategy {

    public WareHouse selectWareHouse(List<WareHouse> wareHouseList);
}

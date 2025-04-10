package org.example.LLDQuestions.Inventory_Management_System_Zepto.controller;

import lombok.Setter;
import org.example.LLDQuestions.Inventory_Management_System_Zepto.model.WareHouse;
import org.example.LLDQuestions.Inventory_Management_System_Zepto.strategy.WareHouseSelectionStrategy;

import java.util.List;

public class WareHouseController {
    List<WareHouse> wareHouseList;
    @Setter
    WareHouseSelectionStrategy wareHouseSelectionStrategy;

    public WareHouseController(List<WareHouse> wareHouseList) {
        this.wareHouseList = wareHouseList;
    }

    public void addWareHouse(WareHouse wareHouse) {
        wareHouseList.add(wareHouse);
    }

    public WareHouse getWareHouse() {
        return wareHouseSelectionStrategy.selectWareHouse(wareHouseList);
    }
}

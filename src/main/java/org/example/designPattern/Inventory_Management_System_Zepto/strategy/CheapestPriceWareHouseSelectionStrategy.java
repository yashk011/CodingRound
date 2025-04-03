package org.example.designPattern.Inventory_Management_System_Zepto.strategy;

import org.example.designPattern.Inventory_Management_System_Zepto.model.WareHouse;

import java.util.List;
import java.util.Random;

public class CheapestPriceWareHouseSelectionStrategy implements WareHouseSelectionStrategy{
    @Override
    public WareHouse selectWareHouse(List<WareHouse> wareHouseList) {
        int size = wareHouseList.size();
        int randomIndex = new Random().nextInt(size);

        return wareHouseList.get(randomIndex);
    }
}

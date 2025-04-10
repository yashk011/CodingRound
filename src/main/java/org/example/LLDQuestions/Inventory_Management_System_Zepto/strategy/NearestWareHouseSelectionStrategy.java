package org.example.LLDQuestions.Inventory_Management_System_Zepto.strategy;

import org.example.LLDQuestions.Inventory_Management_System_Zepto.model.WareHouse;

import java.util.List;
import java.util.Random;

public class NearestWareHouseSelectionStrategy implements WareHouseSelectionStrategy{
    @Override
    public WareHouse selectWareHouse(List<WareHouse> wareHouseList) {
        int size = wareHouseList.size();
        int randomIndex = new Random().nextInt(size);

        return wareHouseList.get(randomIndex);
    }
}

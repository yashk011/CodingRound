package org.example.designPattern.CarRentalSystem;

import org.example.designPattern.CarRentalSystem.model.Location;
import org.example.designPattern.CarRentalSystem.model.Store;
import org.example.designPattern.CarRentalSystem.model.User;

import java.util.ArrayList;
import java.util.List;

public class VehicleRentalSystem {
    List<User> users;
    List<Store> stores;

    static VehicleRentalSystem vehicleRentalSystem;

    public static VehicleRentalSystem getVehicleRentalSystem() {
        if(vehicleRentalSystem == null)
            vehicleRentalSystem = new VehicleRentalSystem();

        return  vehicleRentalSystem;
    }

    private VehicleRentalSystem() {
        users = new ArrayList<>();
        stores = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void addStore(Store store) {
        stores.add(store);
    }

    public Store getStore(Location location) {
        return stores.get(0);
    }
}

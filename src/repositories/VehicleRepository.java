package repositories;

import models.Vehicle;

import java.util.Optional;

public class VehicleRepository {
    public Optional<Vehicle> getVehicleByVehicleNumber(String vehicleNumber) {
        // perform db execution
        return Optional.empty();
    }
    public Vehicle saveVehicle(Vehicle vehicle) {
        // save in db
        return vehicle;
    }
}

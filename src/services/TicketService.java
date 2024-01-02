package services;

import exceptions.GateNotFoundException;
import models.*;
import repositories.GateRepository;
import repositories.ParkingLotRepository;
import repositories.VehicleRepository;

import java.util.Date;
import java.util.Optional;

public class TicketService {
    private GateRepository gateRepository;
    private VehicleRepository vehicleRepository;
    private ParkingLotRepository parkingLotRepository;

    public TicketService(GateRepository gateRepository,
                         VehicleRepository vehicleRepository,
                         ParkingLotRepository parkingLotRepository) {
        this.gateRepository = gateRepository;
        this.vehicleRepository = vehicleRepository;
        this.parkingLotRepository = parkingLotRepository;
    }

    public Ticket issueTicket(String vehicleNumber,
                              VehicleType vehicleType,
                              String ownerName,
                              long gateId) throws GateNotFoundException {
        // 1.Create a ticket object
        // 2.Assign a slot
        // 3.return ticket

        Ticket ticket = new Ticket();
        ticket.setEntryTime(new Date());

        // setting gate
        Optional<Gate> gateOptional = gateRepository.findGetById(gateId);
        if (!gateOptional.isPresent()) throw new GateNotFoundException();
        Gate gate = gateOptional.get();
        ticket.setGeneratedAt(gate);
        ticket.setGenaratedBy(gate.getCurrentOperator());

        // setting vehicle
        Optional<Vehicle> vehicleOptional = vehicleRepository.getVehicleByVehicleNumber(vehicleNumber);
        Vehicle savedVehicle;
        if (vehicleOptional.isPresent()) {
            savedVehicle = vehicleOptional.get();
        } else {
            Vehicle vehicle = new Vehicle();
            vehicle = new Vehicle();
            vehicle.setVehicleNumber(vehicleNumber);
            vehicle.setVehicleType(vehicleType);
            vehicle.setNameOfOwner(ownerName);

            savedVehicle = vehicleRepository.saveVehicle(vehicle);
        }
        ticket.setVehicle(savedVehicle);

        // Assign slot
        SlotAssignmentStrategyType slotAssignmentStrategyType = parkingLotRepository
                .getParkingLotByGate(gate)
                .getSlotAssignmentStrategyType();

        return null;
    }
}

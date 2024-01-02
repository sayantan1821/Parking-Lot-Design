import controllers.TicketController;
import repositories.GateRepository;
import repositories.ParkingLotRepository;
import repositories.TickeRepository;
import repositories.VehicleRepository;
import services.TicketService;

public class ParkingLotApplictaion {
    public static void main(String[] args) {
        GateRepository gateRepository = new GateRepository();
        VehicleRepository vehicleRepository = new VehicleRepository();
        ParkingLotRepository parkingLotRepository =  new ParkingLotRepository();
        TickeRepository tickeRepository = new TickeRepository();

        TicketService ticketService = new TicketService(gateRepository, vehicleRepository, parkingLotRepository, tickeRepository);

        TicketController ticketController = new TicketController(ticketService);
    }
}

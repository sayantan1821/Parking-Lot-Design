package controllers;

import dto.IssueTicketRequestDTO;
import dto.IssueTicketResponseDTO;
import dto.ResponseStatus;
import models.Ticket;
import services.TicketService;

public class TicketController {
    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public IssueTicketResponseDTO issueTicket(IssueTicketRequestDTO req) {
        IssueTicketResponseDTO res = new IssueTicketResponseDTO();
        try{
            Ticket ticket = ticketService.issueTicket(req.getVehicleNumber(),
                    req.getVehicleType(),
                    req.getVehicleOwnerName(),
                    req.getGateId());

            res.setTicket(ticket);
            res.setMessage("Ticket issued successfully.");
            res.setResponseStatus(ResponseStatus.SUCCESS);
            res.setStatusCode(200);
        } catch (Exception e) {
            res.setStatusCode(500);
            res.setError("Failed to issue ticket." + e.getMessage());
            res.setResponseStatus(ResponseStatus.FAILED);
        }
        return res;
    }
}

package dto;

import models.Ticket;

public class IssueTicketResponseDTO extends BaseResponse{
    private Ticket ticket;

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}

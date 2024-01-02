package repositories;

import models.Ticket;

import java.util.Map;
import java.util.TreeMap;

public class TickeRepository {
    private Map<Long, Ticket> tickets = new TreeMap<>();
    private static long id = 0;
    public Ticket saveTicket(Ticket ticket) {
        id++;
        ticket.setId(id);
        tickets.put(id, ticket);
        return ticket;
    }
}

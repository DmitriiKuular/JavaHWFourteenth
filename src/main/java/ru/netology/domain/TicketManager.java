package ru.netology.domain;

import ru.netology.repository.TicketRepository;

import java.util.Arrays;

public class TicketManager {
    private TicketRepository repo;

    public TicketManager(TicketRepository repo) {
        this.repo = repo;
    }

    public void add(Ticket ticket) {
        repo.save(ticket);
    }

    public Ticket[] findTicket(String departureAirport, String arrivalAirport) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repo.findAllTickets()) {
            if ((ticket.getDepartureAirport().equals(departureAirport)) &&
                    (ticket.getArrivalAirport().equals(arrivalAirport))) {
                Ticket[] tmp = Arrays.copyOf(result, result.length + 1);
                tmp[tmp.length - 1] = ticket;
                result = tmp;
                Arrays.sort(result);
            }
        }
        return result;
    }
}

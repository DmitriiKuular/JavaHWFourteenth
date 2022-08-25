package ru.netology.domain;

import ru.netology.repository.TicketRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TicketManagerTest {

    TicketRepository repo = new TicketRepository();
    TicketManager manager = new TicketManager(repo);

    Ticket ticket1 = new Ticket(11, 9700, "OVB", "LED", 380);
    Ticket ticket2 = new Ticket(22, 6800, "VVO", "MOW", 278);
    Ticket ticket3 = new Ticket(33, 9700, "OVB", "LED", 380);
    Ticket ticket4 = new Ticket(44, 24000, "KJA", "MNL", 784);
    Ticket ticket5 = new Ticket(55, 38500, "YKS", "TJM", 320);
    Ticket ticket6 = new Ticket(66, 8600, "KJA", "OVB", 90);
    Ticket ticket7 = new Ticket(77, 7200, "KJA", "OVB", 120);
    Ticket ticket8 = new Ticket(88, 9500, "KJA", "OVB", 60);

    @BeforeEach
    public void setup() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
    }

    @Test
    public void shouldFindTicket() {
        Ticket[] expected = {ticket2};
        Ticket[] actual = manager.findTicket("VVO", "MOW");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindSeveralTickets() {
        Ticket[] expected = {ticket8, ticket6, ticket7};
        Ticket[] actual = manager.findTicket("KJA", "OVB");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindSeveralTicketsWithTheSameTime() {
        Ticket[] expected = {ticket1, ticket3};
        Ticket[] actual = manager.findTicket("OVB", "LED");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindTickets() {
        Ticket[] expected = {};
        Ticket[] actual = manager.findTicket("YKS", "OVB");

        assertArrayEquals(expected, actual);
    }
}

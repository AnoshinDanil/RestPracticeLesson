package ru.anoshindanil.demo.service;

import ru.anoshindanil.demo.entity.Ticket;

public interface TicketService {
    Ticket addTicket(Ticket ticket);
    Ticket getTicket(int id);
    Ticket updateTicket(int id, Ticket ticket);
    void deleteTicket(int id);
    Ticket patchUpdateTicket(int id, Ticket ticket);
}

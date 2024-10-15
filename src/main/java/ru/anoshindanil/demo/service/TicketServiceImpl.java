package ru.anoshindanil.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.anoshindanil.demo.entity.Ticket;
import ru.anoshindanil.demo.exceptions.UserNotFoundException;
import ru.anoshindanil.demo.repository.TicketRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {

    final TicketRepository ticketRepository;

    @Override
    public Ticket addTicket(Ticket ticket) {
        Ticket newTicket = ticketRepository.save(ticket);
        return newTicket;
    }

    @Override
    public Ticket getTicket(int id) {
        Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(()-> new UserNotFoundException());

        return ticket;
    }

    @Override
    public Ticket updateTicket(int id, Ticket ticket) {
        Ticket existingTicket = ticketRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException());

        ticket.setNumber(existingTicket.getNumber());
        ticket.setOwner(existingTicket.getOwner());
        ticket.setDateOfPurchase(existingTicket.getDateOfPurchase());

        return ticketRepository.save(ticket);
    }

    @Override
    public void deleteTicket(int id) {
        ticketRepository.deleteById(id);
    }

    @Override
    public Ticket patchUpdateTicket(int id, Ticket ticket) {
        Ticket existingTicket = ticketRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException());

        if (ticket.getNumber() != 0) {
            existingTicket.setNumber(ticket.getNumber());
        }
        if (!ticket.getOwner().isEmpty()) {
            existingTicket.setOwner(ticket.getOwner());
        }
        if (ticket.getDateOfPurchase() != null) {
            existingTicket.setDateOfPurchase(ticket.getDateOfPurchase());
        }

        return ticketRepository.save(existingTicket);
    }

}

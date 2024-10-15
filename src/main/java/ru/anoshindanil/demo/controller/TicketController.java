package ru.anoshindanil.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.anoshindanil.demo.entity.Ticket;
import ru.anoshindanil.demo.service.TicketService;

@RestController
@RequestMapping("/ticket")
@RequiredArgsConstructor
public class TicketController {

    private final TicketService ticketService;

    @GetMapping("/{id}")
    public Ticket getTicket(@PathVariable int id) {
        return ticketService.getTicket(id);
    }

    @PostMapping("/new")
    public Ticket newTicket(@RequestBody Ticket ticket) {
        return ticketService.addTicket(ticket);
    }

    @PutMapping("/replace/{id}")
    public Ticket patchUpdateTicket(@PathVariable int id, @RequestBody Ticket ticket) {
        return ticketService.patchUpdateTicket(id,ticket);
    }

    @DeleteMapping("/delete")
    public void deleteTicket(@RequestBody Ticket ticket) {
        ticketService.deleteTicket(ticket.getId());
    }

    @PatchMapping("/update/{id}")
    public Ticket updateTicket(@PathVariable int id, @RequestBody Ticket ticket) {
        return ticketService.updateTicket(id, ticket);
    }
}

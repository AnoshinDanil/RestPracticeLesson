package ru.anoshindanil.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.anoshindanil.demo.entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
}

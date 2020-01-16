package com.perscholas.nov2019.philly.capstone.finalproject;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TicketRepository extends CrudRepository<Ticket, Integer> {

    @Transactional
    @Modifying
    @Query(value = "insert into ticket(ticketbuyerid, ticketsellerid, eventid) values(:ticketbuyerid, :ticketsellerid, :eventid)", nativeQuery = true)
    void insertTicket(@Param("ticketbuyerid") Integer ticketbuyerid, @Param("ticketsellerid") Integer ticketsellerid, @Param("eventid") Integer eventid);
}

package com.perscholas.nov2019.philly.capstone.finalproject;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PrintableTicketRepository extends CrudRepository {
    @Query("select e.titleofevent, e.description, e.placeofevent, e.startdate, e.enddate, e.localtimeofshow, ts.name, t.timestamp from Ticket t join TicketSeller ts on t.ticketsellerid = ts.id join Event e on t.eventid = e.id where t.ticketbuyerid = ?1")
    List<PrintableTicket> findPrintableTicketsByBuyerId(@Param("ticketbuyerid") Integer ticketBuyerId);
}

package com.perscholas.nov2019.philly.capstone.finalproject.repositories;

import com.perscholas.nov2019.philly.capstone.finalproject.models.Ticket;
import com.perscholas.nov2019.philly.capstone.finalproject.models.TicketSeller;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TicketRepository extends CrudRepository<Ticket, Integer> {

   /* @Transactional
    @Modifying
    @Query(value = "insert into ticket(ticketbuyerid, ticketsellerid, eventid) values(:ticketbuyerid, :ticketsellerid, :eventid)", nativeQuery = true)
    void insertTicket(@Param("ticketbuyerid") Integer ticketbuyerid, @Param("ticketsellerid") Integer ticketsellerid, @Param("eventid") Integer eventid);*/

    @Query (value = "select t.id from Ticket t where t.eventid = ?1 and t.ticketbuyerid = ?2")
    List<Integer> findTicketIdByEventIdAndBuyerId(@Param("eventid") Integer eventId, @Param("ticketbuyerid") Integer ticketBuyerId);

    @Query(value = "select t.eventid from Ticket t where t.ticketbuyerid = ?1")
    List<Integer> findEventsByBuyerId(@Param("ticketbuyerId") Integer ticketBuyerId);

    @Query(value = "select t.ticketsellerid from Ticket t where t.ticketbuyerid = ?1 and t.eventid = ?2")
    Integer findSellerByBuyerAndEventId(@Param("ticketbuyerId") Integer ticketBuyerId, @Param("eventid") Integer eventId);

    @Transactional
    @Modifying
    @Query("delete from Ticket t where t.eventid = ?1")
    void deleteTicketByEventId(@Param("id") Integer eventId);

}

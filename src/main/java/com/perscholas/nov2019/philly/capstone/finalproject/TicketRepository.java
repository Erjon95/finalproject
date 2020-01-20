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

    //@Query(value =  "select e.titleofevent, e.description, e.placeofevent, e.startdate, e.enddate, e.localtimeofshow, ts.orgname, t.timestamp from Ticket t join event e on t.eventid = e.id join TicketSeller ts on t.ticketsellerid = ts.id join TicketBuyer tb on t.ticketbuyerid = tb.id where t.ticketbuyerid = ?1", nativeQuery = true)
    //List<PrintableTicket> findPrintableTicketsByBuyerId(@Param("ticketbuyerid") Integer ticketBuyerId);

    @Query(value = "select e.titleofevent from Event e join Ticket t on e.id = t.eventid join TicketBuyer tb on t.ticketbuyerid = tb.id where e.id = ?2", nativeQuery = true)
    String findTitleOfEventByEventId(@Param("eventid") Integer eventId);

    @Query(value = "select e.description from Event e join Ticket t on e.id = t.eventid join TicketBuyer tb on t.ticketbuyerid = tb.id where tb.id = ?1", nativeQuery = true)
    String findDescriptionOfEventByBuyerId(@Param("ticketbuyerid") Integer ticketBuyerId);

    @Query(value = "select e.placeofevent from Event e join Ticket t on e.id = t.eventid join TicketBuyer tb on t.ticketbuyerid = tb.id where tb.id = ?1", nativeQuery = true)
    List<String> findPlaceOfEventByBuyerId(@Param("ticketbuyerid") Integer ticketBuyerId);

    @Query(value = "select e.startdate from Event e ts.id join Ticket t on e.id = t.eventid join TicketBuyer tb on t.ticketbuyerid = tb.id where tb.id = ?1", nativeQuery = true)
    List<String> findStartDateOfEventByBuyerId(@Param("ticketbuyerid") Integer ticketBuyerId);

    @Query(value = "select e.enddate from Event e ts.id join Ticket t on e.id = t.eventid join TicketBuyer tb on t.ticketbuyerid = tb.id where tb.id = ?1", nativeQuery = true)
    List<String> findEndDateOfEventByBuyerId(@Param("ticketbuyerid") Integer ticketBuyerId);

    @Query(value = "select e.localtimeofshow from Event e join TicketSeller ts on e.ticketsellerid = ts.id join Ticket t on event.id = t.eventid join TicketBuyer tb on t.ticketbuyerid = tb.id where tb.id = ?1", nativeQuery = true)
    List<String> findTimeOfEventByBuyerId(@Param("ticketbuyerid") Integer ticketBuyerId);

    @Query(value = "select ts.orgname from Event e join TicketSeller ts on e.ticketsellerid = ts.id join Ticket t on event.id = t.eventid join TicketBuyer tb on t.ticketbuyerid = tb.id where tb.id = ?1", nativeQuery = true)
    List<String> findNameOfOrgByBuyerId(@Param("ticketbuyerid") Integer ticketBuyerId);

    @Query(value = "select t.timestamp from Event e join TicketTicketSeller ts on e.ticketsellerid = ts.id join Ticket t on event.id = t.eventid join TicketBuyer tb on t.ticketbuyerid = tb.id where tb.id = ?1", nativeQuery = true)
    List<String> findTimestampOfTicketByBuyerId(@Param("ticketbuyerid") Integer ticketBuyerId);

    @Query (value = "select t.id from Ticket t where t.eventid = ?1 and t.ticketbuyerid = ?2", nativeQuery = true)
    List<Integer> findTicketIdByEventIdAndBuyerId(@Param("eventid") Integer eventId, @Param("ticketbuyerid") Integer ticketBuyerId);

    @Query(value = "select t.eventid from Ticket t where t.ticketbuyerid = ?1", nativeQuery = true)
    List<Integer> findEventsByBuyerId(@Param("ticketbuyerId") Integer ticketBuyerId);
}

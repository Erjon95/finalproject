package com.perscholas.nov2019.philly.capstone.finalproject;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface TicketRepository extends CrudRepository<Ticket, Integer> {

    @Transactional
    @Modifying
    @Query(value = "insert into ticket(ticketbuyerid, eventid, placeofevent, ticketsellerid) values(:ticketsellerid, :titleofevent, :placeofevent, :description, :startdate, :enddate, :localtimeofshow, :priceofticket, :numberoftickets)", nativeQuery = true)
    void insertEvent(@Param("ticketsellerid") Integer ticketsellerid, @Param("titleofevent") String titleofevent, @Param("placeofevent") String placeofevent, @Param("description") String description, @Param("startdate") String startdate, @Param("enddate") String enddate, @Param("localtimeofshow") String localtimeofshow, @Param("priceofticket") String priceofticket, @Param("numberoftickets") Integer numberoftickets);
}

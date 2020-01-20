package com.perscholas.nov2019.philly.capstone.finalproject;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface PrintableTicketRepository extends CrudRepository<PrintableTicket, Integer> {

    @Transactional
    @Modifying
    @Query(value = "insert into printableticket(ticketbuyerid, titleofevent, description, placeofevent, startdate, enddate, localtimeofshow, organizer, timestamp) values (?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8, ?9)", nativeQuery = true)
    public void insert(@Param("ticketbuyerid") Integer ticketBuyerId, @Param("titleofevent") String titleOfEvent, @Param("description") String description, @Param("placeofevent") String placeOfEvent, @Param("startdate") String startDate, @Param("enddate") String endDate, @Param("localtimeofshow") String localTimeOfShow, @Param("organizer") String organizer, @Param("timestamp") String timeStamp);
}

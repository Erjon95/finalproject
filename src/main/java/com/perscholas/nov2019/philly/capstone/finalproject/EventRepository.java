package com.perscholas.nov2019.philly.capstone.finalproject;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EventRepository extends CrudRepository<Event, Integer> {

    @Query("select e from Event e where e.titleofevent like %?1% and e.placeofevent like %?2% and e.description like %?3% and e.startdate like %?4% and e.enddate like %?5% and e.localtimeofshow like %?6%")
    List<Event> findEvents(String titleOfEvent, String placeOfEvent, String description, String startDate, String endDate, String localTimeOfShow);

    @Transactional
    @Modifying
    @Query(value = "insert into event(ticketsellerid, titleofevent, placeofevent, description, startdate, enddate, localtimeofshow, priceofticket, numberoftickets) values(:ticketsellerid, :titleofevent, :placeofevent, :description, :startdate, :enddate, :localtimeofshow, :priceofticket, :numberoftickets)", nativeQuery = true)
    void insertEvent(@Param("ticketsellerid") Integer ticketsellerid, @Param("titleofevent") String titleofevent, @Param("placeofevent") String placeofevent, @Param("description") String description, @Param("startdate") String startdate, @Param("enddate") String enddate, @Param("localtimeofshow") String localtimeofshow, @Param("priceofticket") String priceofticket, @Param("numberoftickets") Integer numberoftickets);



}

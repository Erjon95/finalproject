package com.perscholas.nov2019.philly.capstone.finalproject.repositories;

import com.perscholas.nov2019.philly.capstone.finalproject.models.Event;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EventRepository extends CrudRepository<Event, Integer> {

    @Query("select e from Event e where e.titleofevent like %?1% and e.placeofevent like %?2% and e.description like %?3% and e.startdate like %?4% and e.enddate like %?5% and e.localtimeofshow like %?6%")
    List<Event> findEvents(String titleOfEvent, String placeOfEvent, String description, String startDate, String endDate, String localTimeOfShow);

    @Query("select e from Event e where e.id = ?1")
    Event findEventById(@Param("id") Integer id);

    @Query("select e from Event e where e.ticketsellerid = ?1")
    List<Event> findEventsBySellerId(@Param("ticketsellerid") Integer ticketSellerId);

    @Query("select e.ticketsellerid from Event e where e.id = ?1")
    Integer findSellerId(Integer eventId);

    /*@Transactional
    @Modifying
    @Query(value = "insert into event(ticketsellerid, titleofevent, placeofevent, description, startdate, enddate, localtimeofshow, priceofticket, numberoftickets) values(:ticketsellerid, :titleofevent, :placeofevent, :description, :startdate, :enddate, :localtimeofshow, :priceofticket, :numberoftickets)", nativeQuery = true)
    void insertEvent(@Param("ticketsellerid") Integer ticketsellerid, @Param("titleofevent") String titleofevent, @Param("placeofevent") String placeofevent, @Param("description") String description, @Param("startdate") String startdate, @Param("enddate") String enddate, @Param("localtimeofshow") String localtimeofshow, @Param("priceofticket") String priceofticket, @Param("numberoftickets") Integer numberoftickets);*/

    @Transactional
    @Modifying
    @Query("delete from event where id = ?1")
    void deleteEventByEventId(@Param("id") Integer eventId);
}

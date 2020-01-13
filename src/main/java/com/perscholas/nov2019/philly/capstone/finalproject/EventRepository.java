package com.perscholas.nov2019.philly.capstone.finalproject;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EventRepository extends CrudRepository<Event, Integer> {
    @Query("select e from Event e where e.titleofevent like ?1% and e.placeofevent like ?2% and e.description like ?3% and e.startdate like ?4% and e.enddate like ?5% and e.localtimeofshow like ?6%")
    List<Event> find(String titleOfEvent, String placeOfEvent, String description, String startDate, String endDate, String localTimeOfShow);
}

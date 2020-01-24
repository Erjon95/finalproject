package com.perscholas.nov2019.philly.capstone.finalproject.services;

import com.perscholas.nov2019.philly.capstone.finalproject.models.Event;

import java.util.List;


@org.springframework.stereotype.Service
public class EventService extends Service {

    public boolean isThere(String titleOfEvent, List<Event> le)
    {
        boolean isThere = false;
        for (Event eventTemp: le)
        {
            if (eventTemp.getTitleofevent().toLowerCase().contains(titleOfEvent.toLowerCase() )) {
                isThere = true;
                break;
            }
        }
        return isThere;
    }
}

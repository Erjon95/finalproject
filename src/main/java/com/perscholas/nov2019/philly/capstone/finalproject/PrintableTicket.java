package com.perscholas.nov2019.philly.capstone.finalproject;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PrintableTicket {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private String organizer;
    private String titleofevent;
    private String placeofevent;
    private String description;
    private String startdate;
    private String enddate;
    private String localtimeofshow;
    private String timestamp;

    public String getOrganizer() {
        return organizer;
    }

    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }

    public String getTitleofevent() {
        return titleofevent;
    }

    public void setTitleofevent(String titleofevent) {
        this.titleofevent = titleofevent;
    }

    public String getPlaceofevent() {
        return placeofevent;
    }

    public void setPlaceofevent(String placeofevent) {
        this.placeofevent = placeofevent;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public String getLocaltimeofshow() {
        return localtimeofshow;
    }

    public void setLocaltimeofshow(String localtimeofshow) {
        this.localtimeofshow = localtimeofshow;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}

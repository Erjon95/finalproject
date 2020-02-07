package com.perscholas.nov2019.philly.capstone.finalproject.models;

import java.sql.Blob;

public class PrintableTicket {

    private Integer id;
    private Integer numberoftickets;
    private String titleofevent;
    private String placeofevent;
    private String startdate;
    private String enddate;
    private String description;
    private String localtimeofshow;
    private String priceofticket;
    private String organizer;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrganizer() {
        return organizer;
    }

    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }

    public Integer getNumberoftickets() {
        return numberoftickets;
    }

    public void setNumberoftickets(Integer numberoftickets) {
        this.numberoftickets = numberoftickets;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocaltimeofshow() {
        return localtimeofshow;
    }

    public void setLocaltimeofshow(String localtimeofshow) {
        this.localtimeofshow = localtimeofshow;
    }

    public String getPriceofticket() {
        return priceofticket;
    }

    public void setPriceofticket(String priceofticket) {
        this.priceofticket = priceofticket;
    }
}

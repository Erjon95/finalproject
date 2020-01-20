package com.perscholas.nov2019.philly.capstone.finalproject;

import javax.persistence.*;
import java.sql.Blob;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private Integer ticketsellerid;
    private Integer numberoftickets;
    private String titleofevent;
    private String placeofevent;
    private String startdate;
    private String enddate;
    private String description;
    private String localtimeofshow;
    private String priceofticket;
    private Blob picture;
    private String timestamp;

    /*@ManyToOne
    @JoinColumn(name = "ticketsellerid", insertable = false, updatable = false)
    private TicketSeller ticketseller;

    public TicketSeller getTicketSeller() {
        return ticketseller;
    }

    public void setTicketSeller(TicketSeller ticketSeller) {
        this.ticketseller = ticketSeller;
    }*/

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTicketsellerid() {
        return ticketsellerid;
    }

    public void setTicketsellerid(Integer ticketsellerid) {
        this.ticketsellerid = ticketsellerid;
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

    public Blob getPicture() {
        return picture;
    }

    public void setPicture(Blob picture) {
        this.picture = picture;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String toString( String firstName, String lastName, String organizer) {
        return firstName + " " + lastName + "\n" +
                "titleofevent='" + titleofevent + '\'' +
                ", placeofevent='" + placeofevent + '\'' +
                ", startdate='" + startdate + '\'' +
                ", enddate='" + enddate + '\'' +
                ", description='" + description + '\'' +
                ", localtimeofshow='" + localtimeofshow + '\'' +
                ", organizer='" + organizer
                ;
    }
}

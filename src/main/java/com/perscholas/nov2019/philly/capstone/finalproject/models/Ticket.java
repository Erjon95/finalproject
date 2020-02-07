package com.perscholas.nov2019.philly.capstone.finalproject.models;

import javax.persistence.*;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private Integer ticketbuyerid;
    private Integer ticketsellerid;
    private Integer eventid;
    private String timestamp;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTicketbuyerid() {
        return ticketbuyerid;
    }

    public void setTicketbuyerid(Integer ticketbuyerid) {
        this.ticketbuyerid = ticketbuyerid;
    }

    public Integer getTicketsellerid() {
        return ticketsellerid;
    }

    public void setTicketsellerid(Integer ticketsellerid) {
        this.ticketsellerid = ticketsellerid;
    }

    public Integer getEventid() {
        return eventid;
    }

    public void setEventid(Integer eventid) {
        this.eventid = eventid;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}

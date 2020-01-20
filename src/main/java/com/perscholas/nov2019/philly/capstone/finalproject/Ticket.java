package com.perscholas.nov2019.philly.capstone.finalproject;

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

    /*@OneToOne
    @JoinColumn(name = "ticketbuyerid", insertable = false, updatable = false)
    private TicketBuyer ticketBuyer;

    @ManyToOne
    @JoinColumn(name = "eventid", insertable = false, updatable = false)
    private Event event;

    @ManyToOne
    @JoinColumn(name = "ticketsellerid", insertable = false, updatable = false)
    private TicketSeller ticketSeller;

    public TicketBuyer getTicketBuyer() {
        return ticketBuyer;
    }

    public void setTicketBuyer(TicketBuyer ticketBuyer) {
        this.ticketBuyer = ticketBuyer;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public TicketSeller getTicketSeller() {
        return ticketSeller;
    }

    public void setTicketSeller(TicketSeller ticketSeller) {
        this.ticketSeller = ticketSeller;
    }*/

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

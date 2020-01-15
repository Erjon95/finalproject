package com.perscholas.nov2019.philly.capstone.finalproject;

import org.mindrot.jbcrypt.BCrypt;

import java.util.List;

public class BuyerService extends Service {

    public boolean isThere(String email, String password, List<TicketBuyer> lt) {
        boolean isThere = false;
        for (TicketBuyer buyerTemp: lt)
        {
            if ((buyerTemp.getEmail().toLowerCase().equals(email.toLowerCase()) && (BCrypt.checkpw(password, buyerTemp.getPassword())))) {
                isThere = true;
                break;
            }
        }
        return isThere;
    }

    public boolean isThere(String email, List<TicketBuyer> lt) {
        boolean isThere = false;
        for (TicketBuyer buyerTemp: lt)
        {
            if ((buyerTemp.getEmail().toLowerCase().equals(email.toLowerCase()))) {
                isThere = true;
                break;
            }
        }
        return isThere;
    }
}

package com.perscholas.nov2019.philly.capstone.finalproject;

import org.mindrot.jbcrypt.BCrypt;

import java.util.List;


@org.springframework.stereotype.Service
public class Service {
    public boolean isEventThere(String titleOfEvent, List<Event> le)
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

    public String hashPassword(String password)
    {
        String hashedPwd = BCrypt.hashpw(password, BCrypt.gensalt());
        return hashedPwd;
    }

    public boolean isBuyerThere(String email, String password, List<TicketBuyer> lt)
    {
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

}

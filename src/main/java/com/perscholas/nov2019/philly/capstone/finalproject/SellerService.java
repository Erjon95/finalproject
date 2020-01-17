package com.perscholas.nov2019.philly.capstone.finalproject;

import org.mindrot.jbcrypt.BCrypt;

import java.util.List;

@org.springframework.stereotype.Service
public class SellerService extends Service {

    public boolean isThere(String orgname, String password, List<TicketSeller> ls) {
        boolean isThere = false;
        for (TicketSeller sellerTemp: ls)
        {
            if ((sellerTemp.getOrgname().toLowerCase().equals(orgname.toLowerCase()) && (BCrypt.checkpw(password, sellerTemp.getPassword())))) {
                isThere = true;
                break;
            }
        }
        return isThere;
    }

    public boolean isThere(String orgname, List<TicketSeller> ls) {
        boolean isThere = false;
        for (TicketSeller sellerTemp: ls)
        {
            if ((sellerTemp.getOrgname().toLowerCase().equals(orgname.toLowerCase()))) {
                isThere = true;
                break;
            }
        }
        return isThere;
    }
}

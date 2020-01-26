package com.perscholas.nov2019.philly.capstone.finalproject.services;

import com.perscholas.nov2019.philly.capstone.finalproject.models.TicketSeller;
import com.perscholas.nov2019.philly.capstone.finalproject.repositories.TicketSellerRepository;
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

    public boolean isEmpty(TicketSeller ticketSeller, Integer id, TicketSellerRepository ticketSellerRepository)
    {
        if (ticketSeller.getOrgname().equals("")) {
            String orgName = ticketSellerRepository.findOrgNameById(id);
            ticketSeller.setOrgname(orgName);
        }
        if (ticketSeller.getOrgaddress().equals("")) {
            String orgAddress = ticketSellerRepository.findOrgAddressById(id);
            ticketSeller.setOrgaddress(orgAddress);
        }
        if (ticketSeller.getWebaddress().equals("")) {
            String webAddress = ticketSellerRepository.findWebAddressById(id);
            ticketSeller.setWebaddress(webAddress);
        }
        if (ticketSeller.getContactfirstname().equals("")) {
            String firstName = ticketSellerRepository.findFirstNameById(id);
            ticketSeller.setContactfirstname(firstName);
        }
        if (ticketSeller.getContactlastname().equals("")) {
            String lastName = ticketSellerRepository.findLastNameById(id);
            ticketSeller.setContactlastname(lastName);
        }
        if (ticketSeller.getContactemail().equals("")) {
            String email = ticketSellerRepository.findEmailById(id);
            ticketSeller.setContactemail(email);
        }
        if (ticketSeller.getContactphone().equals("")) {
            String phone = ticketSellerRepository.findPhoneById(id);
            ticketSeller.setContactphone(phone);
        }
        if (ticketSeller.getPassword().equals("")) {
            String password = ticketSellerRepository.findPasswordById(id);
            ticketSeller.setPassword(password);
            return true;
        }
        return false;
    }
}

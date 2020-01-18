package com.perscholas.nov2019.philly.capstone.finalproject;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
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

    public boolean isEmpty(TicketBuyer ticketBuyer, Integer id, TicketBuyerRepository ticketBuyerRepository)
    {
        if (ticketBuyer.getFirstname().equals("")) {
            String firstName = ticketBuyerRepository.findFirstName(id);
            ticketBuyer.setFirstname(firstName);
        }
        if (ticketBuyer.getLastname().equals("")) {
            String lastName = ticketBuyerRepository.findLastName(id);
            ticketBuyer.setLastname(lastName);
        }
        if (ticketBuyer.getAddress().equals("")) {
            String address = ticketBuyerRepository.findAddress(id);
            ticketBuyer.setAddress(address);
        }
        if (ticketBuyer.getEmail().equals("")) {
            String email = ticketBuyerRepository.findEmail(id);
            ticketBuyer.setEmail(email);
        }
        if (ticketBuyer.getPhone().equals("")) {
            String phone = ticketBuyerRepository.findPhone(id);
            ticketBuyer.setPhone(phone);
        }
        if (ticketBuyer.getPassword().equals("")) {
            String password = ticketBuyerRepository.findPassword(id);
            ticketBuyer.setPassword(password);
            return true;
        }
        return false;
    }
}

package com.perscholas.nov2019.philly.capstone.finalproject;

import org.mindrot.jbcrypt.BCrypt;

import java.util.List;

@org.springframework.stereotype.Service
public class BuyerService extends Service {

    private TicketBuyerRepository ticketBuyerRepository;

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

    public boolean isNull (TicketBuyer ticketBuyer, Integer id) {
        if (ticketBuyer.getFirstname().equals(null)) {
            String firstName = ticketBuyerRepository.findFirstName(id);
            ticketBuyer.setFirstname(firstName);
        }

        if (ticketBuyer.getLastname().equals(null)) {
            String lastName = ticketBuyerRepository.findLastName(id);
            ticketBuyer.setLastname(lastName);
        }

        if (ticketBuyer.getAddress().equals(null)) {
            String address = ticketBuyerRepository.findAddress(id);
            ticketBuyer.setAddress(address);
        }

        if (ticketBuyer.getEmail().equals(null)) {
            String email = ticketBuyerRepository.findEmail(id);
            ticketBuyer.setFirstname(email);
        }

        if (ticketBuyer.getPhone().equals(null)) {
            String phone = ticketBuyerRepository.findPhone(id);
            ticketBuyer.setPhone(phone);
        }

        if (ticketBuyer.getPassword().equals(null)) {
            String password = ticketBuyerRepository.findPassword(id);
            ticketBuyer.setFirstname(password);
            return true;
        }
        return false;
    }

}

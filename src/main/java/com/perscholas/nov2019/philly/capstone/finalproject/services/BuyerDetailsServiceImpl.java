package com.perscholas.nov2019.philly.capstone.finalproject.services;

import com.perscholas.nov2019.philly.capstone.finalproject.MyBuyerDetails;
import com.perscholas.nov2019.philly.capstone.finalproject.models.TicketBuyer;
import com.perscholas.nov2019.philly.capstone.finalproject.repositories.TicketBuyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class BuyerDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private TicketBuyerRepository ticketBuyerRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        TicketBuyer ticketBuyer = ticketBuyerRepository.findBuyerByEmail(s);
        return new MyBuyerDetails(ticketBuyer);
    }
}

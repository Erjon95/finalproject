package com.perscholas.nov2019.philly.capstone.finalproject.services;

import com.perscholas.nov2019.philly.capstone.finalproject.MyUserDetails;
import com.perscholas.nov2019.philly.capstone.finalproject.models.TicketBuyer;
import com.perscholas.nov2019.philly.capstone.finalproject.repositories.TicketBuyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Service
public class BuyerDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private TicketBuyerRepository ticketBuyerRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        TicketBuyer ticketBuyer = ticketBuyerRepository.findBuyerByEmail(s);
        return new MyUserDetails(ticketBuyer);
    }
    /*@Autowired
    private TicketBuyerRepository ticketBuyerRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        TicketBuyer ticketBuyer = ticketBuyerRepository.findBuyerByEmail(s);

        Set grantedAuthorities = new HashSet<>();

        grantedAuthorities.add(new SimpleGrantedAuthority(ticketBuyer.getRole()));

        return new org.springframework.security.core.userdetails.User(ticketBuyer.getEmail(),
                ticketBuyer.getPassword(), grantedAuthorities);
    }*/
}

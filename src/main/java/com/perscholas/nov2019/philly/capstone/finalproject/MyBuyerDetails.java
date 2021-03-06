package com.perscholas.nov2019.philly.capstone.finalproject;

import com.perscholas.nov2019.philly.capstone.finalproject.models.TicketBuyer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class MyBuyerDetails implements UserDetails {
    String email;
    String password;
    List<GrantedAuthority> grantedAuthorities;

    public MyBuyerDetails(){}

    public MyBuyerDetails(TicketBuyer ticketBuyer)
    {
        try {
            email = ticketBuyer.getEmail();
            password = ticketBuyer.getPassword();
            grantedAuthorities = Arrays.asList(new SimpleGrantedAuthority(ticketBuyer.getRole()));
        }catch (NullPointerException npe){
            System.out.println("NullPointerException: email not found");
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

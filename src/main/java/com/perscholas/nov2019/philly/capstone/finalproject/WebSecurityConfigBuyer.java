package com.perscholas.nov2019.philly.capstone.finalproject;

import com.perscholas.nov2019.philly.capstone.finalproject.services.BuyerDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public  class WebSecurityConfigBuyer extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure (HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/buyer-account", "/edit-buyer", "/index-success", "/buy_result").authenticated()
                .antMatchers("/register-buyer", "/", "/search_result", "/resources/**").permitAll()
                .and().formLogin()
                .loginPage("/login-buyer").usernameParameter("email").passwordParameter("password").permitAll();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder () {
        return new BCryptPasswordEncoder(4);
    }

    @Autowired
    BuyerDetailsServiceImpl userDetailsService;

    @Autowired
    public void configureGlobal (AuthenticationManagerBuilder auth) throws Exception {
        // Setting Service to find User in the database.
        // And Setting bCryptPassswordEncoder
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }
}




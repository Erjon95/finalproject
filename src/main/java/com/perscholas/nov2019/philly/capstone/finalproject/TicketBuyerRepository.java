package com.perscholas.nov2019.philly.capstone.finalproject;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TicketBuyerRepository extends CrudRepository<TicketBuyer, Integer> {

    @Query(value = "select * from TicketBuyer tb", nativeQuery = true)
    List<TicketBuyer> findBuyers();

    @Transactional
    @Modifying
    @Query(value = "insert into ticketbuyer(firstname, lastname, address, email, phone, password) values(:firstname, :lastname, :address, :email, :phone, :password)", nativeQuery = true)
    void registerBuyer(@Param("firstname") String firstname, @Param("lastname") String lastname, @Param("address") String address, @Param("email") String email, @Param("phone") String phone, @Param("password") String password);

}

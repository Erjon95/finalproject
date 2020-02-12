package com.perscholas.nov2019.philly.capstone.finalproject.repositories;

import com.perscholas.nov2019.philly.capstone.finalproject.models.TicketBuyer;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TicketBuyerRepository extends CrudRepository<TicketBuyer, Integer> {

    @Query(value = "select tb.id from TicketBuyer tb where tb.email = ?1", nativeQuery = true)
    Integer findBuyerId(String email);

    @Query(value = "select * from TicketBuyer tb where tb.id = ?1", nativeQuery = true)
    TicketBuyer findBuyerById(Integer id);

    @Query(value = "select * from TicketBuyer tb where tb.email = ?1", nativeQuery = true)
    TicketBuyer findBuyerByEmail(String email);

    @Query(value = "select * from TicketBuyer tb", nativeQuery = true)
    List<TicketBuyer> findBuyers();

    @Query(value = "select tb.firstname from TicketBuyer tb where tb.id = ?1", nativeQuery = true)
    String findFirstName(Integer id);

    @Query(value = "select tb.lastname from TicketBuyer tb where tb.id = ?1", nativeQuery = true)
    String findLastName(Integer id);

    @Query(value = "select tb.address from TicketBuyer tb where tb.id = ?1", nativeQuery = true)
    String findAddress(Integer id);

    @Query(value = "select tb.email from TicketBuyer tb where tb.id = ?1", nativeQuery = true)
    String findEmail(Integer id);

    @Query(value = "select tb.phone from TicketBuyer tb where tb.id = ?1", nativeQuery = true)
    String findPhone(Integer id);

    @Query(value = "select tb.password from TicketBuyer tb where tb.id = ?1", nativeQuery = true)
    String findPassword(Integer id);

    @Transactional
    @Modifying
    @Query(value = "insert into ticketbuyer(firstname, lastname, address, email, phone, password, role) values(:firstname, :lastname, :address, :email, :phone, :password, :role)", nativeQuery = true)
    void registerBuyer(@Param("firstname") String firstname, @Param("lastname") String lastname, @Param("address") String address, @Param("email") String email, @Param("phone") String phone, @Param("password") String password, @Param("role") String role);

    @Transactional
    @Modifying
    @Query(value = "update TicketBuyer tb set tb.firstname = ?1, tb.lastname = ?2, tb. address = ?3, tb.email = ?4, tb.phone = ?5, tb.password = ?6 where tb.id = ?7", nativeQuery = true)
    void update(@Param("firstname") String firstname, @Param("lastname") String lastname, @Param("address") String address, @Param("email") String email, @Param("phone") String phone, @Param("password") String password, @Param("id") Integer id);
}
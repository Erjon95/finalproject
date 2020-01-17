package com.perscholas.nov2019.philly.capstone.finalproject;

import org.mindrot.jbcrypt.BCrypt;
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
    @Query(value = "insert into ticketbuyer(firstname, lastname, address, email, phone, password) values(:firstname, :lastname, :address, :email, :phone, :password)", nativeQuery = true)
    void registerBuyer(@Param("firstname") String firstname, @Param("lastname") String lastname, @Param("address") String address, @Param("email") String email, @Param("phone") String phone, @Param("password") String password);

    @Transactional
    @Modifying
    @Query(value = "update TicketBuyer tb set tb.firstname = ?1, tb.lastname = ?2, tb. address = ?3, tb.email = ?4, tb.phone = ?5, tb.password = ?6 where tb.id = ?7", nativeQuery = true)
    void update(@Param("firstname") String firstname, @Param("lastname") String lastname, @Param("address") String address, @Param("email") String email, @Param("phone") String phone, @Param("password") String password, @Param("id") Integer id);

    @Transactional
    @Modifying
    @Query(value = "update TicketBuyer tb set tb.firstname = ?1 where tb.id = ?2", nativeQuery = true)
    void updateFirstName(@Param("firstname") String firstname, @Param("id") Integer id);

    @Transactional
    @Modifying
    @Query(value = "update TicketBuyer tb set tb.lastname = ?1 where tb.id = ?2", nativeQuery = true)
    void updateLastName(@Param("lastname") String lastname, @Param("id") Integer id);

    @Transactional
    @Modifying
    @Query(value = "update TicketBuyer tb set tb.address = ?1 where tb.id = ?2", nativeQuery = true)
    void updateAddress(@Param("address") String address, @Param("id") Integer id);

    @Transactional
    @Modifying
    @Query(value = "update TicketBuyer tb set tb.email = ?1 where tb.id = ?2", nativeQuery = true)
    void updateEmail(@Param("email") String email, @Param("id") Integer id);

    @Transactional
    @Modifying
    @Query(value = "update TicketBuyer tb set tb.phone = ?1 where tb.id = ?2", nativeQuery = true)
    void updatePhone(@Param("phone") String phone, @Param("id") Integer id);

    @Transactional
    @Modifying
    @Query(value = "update TicketBuyer tb set tb.password = ?1 where tb.id = ?2", nativeQuery = true)
    void updatePassword(@Param("password") String password, @Param("id") Integer id);

}

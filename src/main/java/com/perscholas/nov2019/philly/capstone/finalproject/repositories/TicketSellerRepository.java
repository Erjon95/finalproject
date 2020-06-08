package com.perscholas.nov2019.philly.capstone.finalproject.repositories;

import com.perscholas.nov2019.philly.capstone.finalproject.models.TicketSeller;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TicketSellerRepository extends CrudRepository<TicketSeller, Integer> {

    @Query(value = "select ts from TicketSeller ts")
    List<TicketSeller> findSellers();

    @Query(value = "select ts from TicketSeller ts where ts.orgname = ?1")
    TicketSeller findSellerByOrgName(@Param("orgname") String orgName);

    @Query(value = "select ts from TicketSeller ts where ts.id = ?1")
    TicketSeller findSellerById(@Param("id") Integer id);

    @Query(value = "select ts.contactfirstname from TicketSeller ts where ts.id = ?1")
    String findFirstNameById(Integer id);

    @Query(value = "select ts.contactlastname from TicketSeller ts where ts.id = ?1")
    String findLastNameById(Integer id);

    @Query(value = "select ts.orgaddress from TicketSeller ts where ts.id = ?1")
    String findOrgAddressById(Integer id);

    @Query(value = "select ts.contactemail from TicketSeller ts where ts.id = ?1")
    String findEmailById(Integer id);

    @Query(value = "select ts.contactphone from TicketSeller ts where ts.id = ?1")
    String findPhoneById(Integer id);

    @Query(value = "select ts.password from TicketSeller ts where ts.id = ?1")
    String findPasswordById(Integer id);

    @Query(value = "select ts.orgname from TicketSeller ts where ts.id = ?1")
    String findOrgNameById(Integer id);

    @Query(value = "select ts.webaddress from TicketSeller ts where ts.id = ?1")
    String findWebAddressById(Integer id);

    @Transactional
    @Modifying
    @Query(value = "insert into ticket_seller(orgname, orgaddress, webaddress, contactfirstname, contactlastname, contactemail, contactphone, password) values(:orgname, :orgaddress, :webaddress, :contactfirstname, :contactlastname, :contactemail, :contactphone, :password)", nativeQuery = true)
    void registerSeller(@Param("orgname") String orgname, @Param("orgaddress") String orgaddress, @Param("webaddress") String webaddress, @Param("contactfirstname") String contactfirstname, @Param("contactlastname") String contactlastname, @Param("contactemail") String contactemail, @Param("contactphone") String contactphone, @Param("password") String password);

    @Transactional
    @Modifying
    @Query("update TicketSeller ts set ts.orgname = ?1, ts.orgaddress = ?2, ts. webaddress = ?3, ts.contactfirstname = ?4, ts.contactlastname = ?5, ts.contactemail = ?6, ts.contactphone = ?7, ts.password = ?8 where ts.id = ?9")
    void update(@Param("orgname") String orgName, @Param("orgaddress") String orgAddress, @Param("webaddress") String website, @Param("contactfirstname") String firstName, @Param("contactlastname") String lastName, @Param("contactemail") String email, @Param("contactphone") String phone, @Param("password") String password, @Param("id") Integer id);

}

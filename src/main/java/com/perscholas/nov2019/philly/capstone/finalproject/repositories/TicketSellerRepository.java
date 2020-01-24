package com.perscholas.nov2019.philly.capstone.finalproject.repositories;

import com.perscholas.nov2019.philly.capstone.finalproject.models.TicketSeller;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TicketSellerRepository extends CrudRepository<TicketSeller, Integer> {

    @Query(value = "select * from TicketSeller ts", nativeQuery = true)
    List<TicketSeller> findSellers();

    @Query(value = "select * from TicketSeller ts where ts.orgname = ?1", nativeQuery = true)
    TicketSeller findSellerByOrgName(@Param("orgname") String orgName);

    @Transactional
    @Modifying
    @Query(value = "insert into ticketseller(orgname, orgaddress, webaddress, contactfirstname, contactlastname, contactemail, contactphone, password) values(:orgname, :orgaddress, :webaddress, :contactfirstname, :contactlastname, :contactemail, :contactphone, :password)", nativeQuery = true)
    void registerSeller(@Param("orgname") String orgname, @Param("orgaddress") String orgaddress, @Param("webaddress") String webaddress, @Param("contactfirstname") String contactfirstname, @Param("contactlastname") String contactlastname, @Param("contactemail") String contactemail, @Param("contactphone") String contactphone, @Param("password") String password);

}

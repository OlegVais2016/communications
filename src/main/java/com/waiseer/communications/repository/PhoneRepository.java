package com.waiseer.communications.repository;

import com.waiseer.communications.model.entity.Client;
import com.waiseer.communications.model.entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PhoneRepository extends JpaRepository<Phone,Long> {
    //List<Phone> findByClientId(Long clientId);
    // List<Phone> findAllByClientId(Long clientId);
    //@Query("select * from Phone  where p.clientId = :clientId")
    //List<Phone> findAllByClientId(Long clientId);

  /* @Query("select p from Phone p where p.clientId = :clientId")
    List<Phone> findAll(Long clientId);*/
}

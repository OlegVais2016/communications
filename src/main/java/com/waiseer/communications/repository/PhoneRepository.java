package com.waiseer.communications.repository;

import com.waiseer.communications.model.entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<Phone,Long> {

}

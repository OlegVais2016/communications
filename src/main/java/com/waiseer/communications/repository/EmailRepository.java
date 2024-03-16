package com.waiseer.communications.repository;

import com.waiseer.communications.model.entity.Email;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<Email, Long> {

}

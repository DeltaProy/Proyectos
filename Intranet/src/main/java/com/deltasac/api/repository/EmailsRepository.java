package com.deltasac.api.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.deltasac.api.entity.Email;
import com.deltasac.api.entity.EmailPK;

public interface EmailsRepository extends JpaRepository<Email, EmailPK>{

}

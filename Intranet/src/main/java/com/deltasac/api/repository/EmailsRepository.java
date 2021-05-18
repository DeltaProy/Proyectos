package com.deltasac.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.deltasac.api.entity.Email;
import com.deltasac.api.entity.EmailPK;

public interface EmailsRepository extends JpaRepository<Email, EmailPK>{
	
	@Transactional
	@Modifying
	@Query("DELETE FROM Email e WHERE e.idpersonal=?1")
	public void eliminarPorPersonal(int idPersonal);
}

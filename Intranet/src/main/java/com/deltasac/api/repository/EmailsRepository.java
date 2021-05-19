package com.deltasac.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.deltasac.api.entity.Email;
import com.deltasac.api.entity.EmailPK;

public interface EmailsRepository extends JpaRepository<Email, EmailPK>{
	
	@Transactional
	@Modifying
	@Query("UPDATE Email e SET e.estadoemail = 'E' WHERE e.idpersonal=?1 AND e.estadoemail = 'A'")
	public void eliminarPorPersonal(Integer idPersonal);
	
	@Query("SELECT max(e.nroemail) FROM Email e WHERE e.idpersonal=?1")
	public Integer buscarUltimoNroemail(Integer idPersonal);
	
	@Query("SELECT e FROM Email e WHERE e.estadoemail = 'A'")
	public List<Email> buscarEmails();
}

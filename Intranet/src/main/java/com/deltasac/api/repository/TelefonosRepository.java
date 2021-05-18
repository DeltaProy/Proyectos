package com.deltasac.api.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.deltasac.api.entity.Telefono;
import com.deltasac.api.entity.TelefonoPK;

public interface TelefonosRepository extends JpaRepository<Telefono, TelefonoPK>{
	@Transactional
	@Modifying
	@Query("DELETE FROM Telefono t WHERE t.idpersonal=?1")
	public void eliminarPorPersonal(int idPersonal);
}

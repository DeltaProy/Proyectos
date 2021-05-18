package com.deltasac.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.deltasac.api.entity.Direccion;
import com.deltasac.api.entity.DireccionPK;

public interface DireccionesRepository extends JpaRepository<Direccion, DireccionPK>{

	@Transactional
	@Modifying
	@Query("DELETE FROM Direccion d WHERE d.idpersonal=?1")
	public void eliminarPorPersonal(int idPersonal);
}

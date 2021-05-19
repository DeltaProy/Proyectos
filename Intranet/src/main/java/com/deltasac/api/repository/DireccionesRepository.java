package com.deltasac.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.deltasac.api.entity.Direccion;
import com.deltasac.api.entity.DireccionPK;

public interface DireccionesRepository extends JpaRepository<Direccion, DireccionPK>{

	@Transactional
	@Modifying
	@Query("UPDATE Direccion d SET d.estadodireccion = 'E' WHERE d.idpersonal=?1 AND d.estadodireccion = 'A'")
	public void eliminarPorPersonal(int idPersonal);
	
	@Query("SELECT max(d.nrodir) FROM Direccion d WHERE d.idpersonal=?1")
	public Integer buscarUltimoNrodir(Integer idPersonal);
	
	@Query("SELECT d FROM Direccion d WHERE d.estadodireccion = 'A'")
	public List<Direccion> buscarDirecciones();
	
}

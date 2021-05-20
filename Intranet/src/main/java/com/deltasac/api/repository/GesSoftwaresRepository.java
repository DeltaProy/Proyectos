package com.deltasac.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.deltasac.api.entity.GesSoftware;
import com.deltasac.api.entity.GesSoftwarePK;

public interface GesSoftwaresRepository extends JpaRepository<GesSoftware, GesSoftwarePK>{

	@Transactional
	@Modifying
	@Query("DELETE FROM GesSoftware s WHERE s.idpersonal=?1")
	public void eliminarPorPersonal(int idPersonal);
	
	/*	
	@Query("SELECT d FROM Direccion d WHERE d.estadodireccion = 'A'")
	public List<GesSoftware> buscarDirecciones();
	*/
}

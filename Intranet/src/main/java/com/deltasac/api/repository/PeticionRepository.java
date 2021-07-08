package com.deltasac.api.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.deltasac.api.entity.Peticion;

public interface PeticionRepository extends JpaRepository<Peticion, Integer> {

	@Query("SELECT p FROM Peticion p WHERE p.idarea=?1 AND (p.estado<>'FINALIZADA' AND p.estado<>'CANCELADA')")
	public List<Peticion> buscarPeticionPorArea(Integer idarea);
	
	@Query("SELECT p FROM Peticion p WHERE p.idasignado=?1 AND (p.estado<>'FINALIZADA' AND p.estado<>'CANCELADA')")
	public List<Peticion> buscarPeticionPorAsignado(Integer idasignado);
	
	@Query("SELECT p FROM Peticion p WHERE p.idusuario=?1 AND (p.estado<>'FINALIZADA' AND p.estado<>'CANCELADA')")
	public List<Peticion> buscarPeticionPorUsuario(Integer idusuario);
}

package com.deltasac.api.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.deltasac.api.entity.Personal;

public interface PersonalRepository extends JpaRepository<Personal, Integer>{

	@Query("SELECT p FROM Personal p WHERE p.idarea = ?1")
	public List<Personal> listarPorArea(int idarea);
	
	@Query("SELECT p FROM Personal p WHERE p.nomper = ?1 AND p.apeper = ?2")
	public Personal buscarPorNombre(String nomper, String apeper);
}

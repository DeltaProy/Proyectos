package com.deltasac.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.deltasac.api.entity.Area;

public interface AreaRepository extends JpaRepository<Area, Integer> {
	@Query("SELECT a FROM Area a WHERE a.idresponsable = ?1")
	public Area buscarAreaPorIdresponsable(int idresponsable);
	
}

package com.deltasac.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.deltasac.api.entity.PeticionDet;
import com.deltasac.api.entity.PeticionDetPK;

public interface PeticionDetRepository extends JpaRepository<PeticionDet, PeticionDetPK> {

	@Query("SELECT p FROM PeticionDet p WHERE p.idpeticion=?1")
	public List<PeticionDet> buscarPorPeticion(Integer idpeticion);
}

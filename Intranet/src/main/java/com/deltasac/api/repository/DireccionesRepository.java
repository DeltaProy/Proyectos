package com.deltasac.api.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.deltasac.api.entity.Direccion;
import com.deltasac.api.entity.DireccionPK;

public interface DireccionesRepository extends JpaRepository<Direccion, DireccionPK>{

}

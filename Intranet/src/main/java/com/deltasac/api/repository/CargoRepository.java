package com.deltasac.api.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.deltasac.api.entity.Cargo;
import com.deltasac.api.entity.CargoPK;

public interface CargoRepository extends JpaRepository<Cargo, CargoPK>{

}

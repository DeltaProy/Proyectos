package com.deltasac.api.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.deltasac.api.entity.ProyectoHomologado;
import com.deltasac.api.entity.ProyectoHomologadoPK;

public interface ProyectoHomologadosRepository extends JpaRepository<ProyectoHomologado, ProyectoHomologadoPK>{

}

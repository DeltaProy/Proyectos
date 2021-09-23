package com.deltasac.api.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.deltasac.api.entity.ProyectoHomologado;
import com.deltasac.api.entity.ProyectoHomologadoPK;

public interface ProyectoHomologadosRepository extends JpaRepository<ProyectoHomologado, ProyectoHomologadoPK>{
	@Query("SELECT ph FROM ProyectoHomologado ph WHERE ph.idproyecto=?1")
	public List<ProyectoHomologado> listarPorIdProyecto(int idproyecto);
}

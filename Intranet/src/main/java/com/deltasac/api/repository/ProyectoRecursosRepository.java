package com.deltasac.api.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.deltasac.api.entity.ProyectoRecurso;
import com.deltasac.api.entity.ProyectoRecursoPK;

public interface ProyectoRecursosRepository extends JpaRepository<ProyectoRecurso, ProyectoRecursoPK>{
	@Query("SELECT pr FROM ProyectoRecurso pr WHERE pr.idproyecto=?1")
	public List<ProyectoRecurso> buscarPorIdProyecto(int idProyecto);
}

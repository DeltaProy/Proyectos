package com.deltasac.api.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.deltasac.api.entity.Email;
import com.deltasac.api.entity.Proyecto;

public interface ProyectosRepository extends JpaRepository<Proyecto, Integer>{
	
	@Query("SELECT p FROM Proyecto p WHERE p.desproyecto=?1")
	public Proyecto buscarPorNombre(String nombreProyecto);
	
	@Query(value = "{call GET_PROYECTOS_POR_RESPONSABLE(:idresponsable)}", nativeQuery = true)
	public List<Proyecto> listarProyectosPorResponsable(@Param("idresponsable") int idresponsable);
	

}

package com.deltasac.api.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.deltasac.api.entity.ProyectoTarea;
import com.deltasac.api.entity.ProyectoTareaPK;

public interface ProyectoTareasRepository extends JpaRepository<ProyectoTarea, Integer>{

	@Transactional
	@Modifying
	@Query("DELETE FROM ProyectoTarea t WHERE t.idproyecto=?1")
	public void eliminarPorProyecto(int idProyecto);
}

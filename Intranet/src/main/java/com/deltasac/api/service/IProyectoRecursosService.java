package com.deltasac.api.service;

import java.util.List;

import com.deltasac.api.entity.ProyectoRecurso;
import com.deltasac.api.entity.ProyectoRecursoPK;

public interface IProyectoRecursosService {

	List<ProyectoRecurso> buscarTodos();
	List<ProyectoRecurso> buscarPorIdProyecto(int idProyecto);
	void guardar(ProyectoRecurso proyectoRecurso);
	void eliminar(ProyectoRecursoPK proyectoRecursoPK);
	ProyectoRecurso buscarPorId(ProyectoRecursoPK proyectoRecursoPK);
}

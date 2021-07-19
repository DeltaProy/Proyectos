package com.deltasac.api.service;

import java.util.List;

import com.deltasac.api.entity.ProyectoTarea;
import com.deltasac.api.entity.ProyectoTareaPK;

public interface IProyectoTareasService {

	List<ProyectoTarea> buscarTodos();
	void guardar(ProyectoTarea proyectoTarea);
	void eliminar(ProyectoTareaPK proyectoTareaPK);
	void eliminarPorProyecto(int idProyecto);
	ProyectoTarea buscarPorId(ProyectoTareaPK proyectoTareaPK);
}

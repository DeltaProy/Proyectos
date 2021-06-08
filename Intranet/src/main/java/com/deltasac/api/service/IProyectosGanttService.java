package com.deltasac.api.service;

import java.util.List;

import com.deltasac.api.entity.ProyectoGantt;

public interface IProyectosGanttService {

	List<ProyectoGantt> buscarTodos();
	void guardar(ProyectoGantt proyectoGantt);
	void eliminar(Integer idProyectoGantt);
	ProyectoGantt buscarPorId(Integer idProyectoGantt);
}

package com.deltasac.api.service;

import java.util.List;

import com.deltasac.api.entity.ProyectoHomologado;
import com.deltasac.api.entity.ProyectoHomologadoPK;

public interface IProyectoHomologadosService {

	List<ProyectoHomologado> buscarTodos();
	void guardar(ProyectoHomologado proyectoHomologado);
	void eliminar(ProyectoHomologadoPK proyectoHomologadoPK);
	ProyectoHomologado buscarPorId(ProyectoHomologadoPK proyectoHomologadoPK);
}

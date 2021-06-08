package com.deltasac.api.service;

import java.util.List;

import com.deltasac.api.entity.Proyecto;

public interface IProyectosService {

	List<Proyecto> buscarTodos();
	void guardar(Proyecto proyecto);
	void eliminar(Integer idProyecto);
	Proyecto buscarPorId(int idProyecto);
}

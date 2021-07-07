package com.deltasac.api.service;

import java.util.List;

import com.deltasac.api.entity.Area;

public interface IAreaService {

	List<Area> buscarTodos();
	void guardar(Area area);
	void eliminar(int idArea);
	Area buscarId(int idArea);
	Area buscarAreaPorIdresponsable(int idResponsable);
}

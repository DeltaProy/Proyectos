package com.deltasac.api.service;

import java.util.List;

import com.deltasac.api.entity.Personal;

public interface IPersonalService {

	List<Personal> buscarTodos();
	void guardar(Personal personal);
	void eliminar(Integer idPersonal);
	Personal buscarPorId(int idPersonal);
	Personal buscarPorNombre(String nomper, String apeper);
	List<Personal> buscarPorArea(int idarea);
}

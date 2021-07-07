package com.deltasac.api.service;

import java.util.List;

import com.deltasac.api.entity.Peticion;

public interface IPeticionService {

	List<Peticion> buscarTodos();
	void guardar(Peticion peticion);
	void eliminar(Integer idPeticion);
	Peticion buscarId(Integer idPeticion);
	List<Peticion> buscarbuscarPeticionPorArea(Integer idArea);
	List<Peticion> buscarbuscarPeticionPorAsignado(Integer idAsignado);
	List<Peticion> buscarbuscarPeticionPorUsuario(Integer idUsuario);
}

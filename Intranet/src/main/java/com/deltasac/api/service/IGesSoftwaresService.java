package com.deltasac.api.service;

import java.util.List;

import com.deltasac.api.entity.GesSoftware;
import com.deltasac.api.entity.GesSoftwarePK;

public interface IGesSoftwaresService {

	List<GesSoftware> buscarTodos();
	void guardar(GesSoftware direccion);
	void eliminar(GesSoftwarePK gesSoftwarePK);
	void eliminarPorPersonal(int idPersonal);
}

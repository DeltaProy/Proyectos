package com.deltasac.api.service;

import java.util.List;

import com.deltasac.api.entity.Direccion;
import com.deltasac.api.entity.DireccionPK;

public interface IDireccionesService {

	List<Direccion> buscarTodos();
	void guardar(Direccion direccion);
	void eliminar(DireccionPK direccionPK);
	void eliminarPorPersonal(int idPersonal);
}

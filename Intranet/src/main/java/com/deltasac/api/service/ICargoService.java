package com.deltasac.api.service;

import java.util.List;

import com.deltasac.api.entity.Cargo;
import com.deltasac.api.entity.CargoPK;

public interface ICargoService {

	List<Cargo> buscarTodos();
	void guardar(Cargo cargo);
	void eliminar(CargoPK cargoPK);
	Cargo buscarId(CargoPK cargoPK);
}

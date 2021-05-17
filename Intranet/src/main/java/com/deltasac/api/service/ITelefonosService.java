package com.deltasac.api.service;

import java.util.List;

import com.deltasac.api.entity.Telefono;
import com.deltasac.api.entity.TelefonoPK;

public interface ITelefonosService {

	List<Telefono> buscarTodos();
	void guardar(Telefono telefono);
	void eliminar(TelefonoPK telefonoPK);
}

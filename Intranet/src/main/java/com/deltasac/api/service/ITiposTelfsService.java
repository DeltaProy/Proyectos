package com.deltasac.api.service;

import java.util.List;

import com.deltasac.api.entity.TipoTelf;

public interface ITiposTelfsService {

	List<TipoTelf> buscarTodos();
	void guardar(TipoTelf tipoTelf);
	void eliminar(int idTipoTelf);
}

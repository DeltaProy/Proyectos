package com.deltasac.api.service;

import java.util.List;

import com.deltasac.api.entity.TipoSoft;

public interface ITiposSoftService {

	List<TipoSoft> buscarTodos();
	void guardar(TipoSoft tipoSoft);
	void eliminar(int idTipoSoft);
	TipoSoft buscarPorId(int idTipoSoft);
}

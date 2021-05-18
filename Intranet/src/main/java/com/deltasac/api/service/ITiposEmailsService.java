package com.deltasac.api.service;

import java.util.List;

import com.deltasac.api.entity.TipoEmail;

public interface ITiposEmailsService {

	List<TipoEmail> buscarTodos();
	void guardar(TipoEmail tipoEmail);
	void eliminar(int idTipoEmail);
	TipoEmail buscarPorId(Integer idTipoEmail);
}

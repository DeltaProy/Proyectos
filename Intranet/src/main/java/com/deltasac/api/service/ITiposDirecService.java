package com.deltasac.api.service;

import java.util.List;

import com.deltasac.api.entity.TipoDirec;

public interface ITiposDirecService {

	List<TipoDirec> buscarTodos();
	void guardar(TipoDirec tipoDirec);
	void eliminar(int idTipoDirec);
	TipoDirec buscarPorId(int idTipoDirec);
}

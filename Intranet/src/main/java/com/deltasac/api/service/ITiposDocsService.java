package com.deltasac.api.service;

import java.util.List;

import com.deltasac.api.entity.TipoDoc;

public interface ITiposDocsService {

	List<TipoDoc> buscarTodos();
	void guardar(TipoDoc tipodoc);
	void eliminar(int idTipoDoc);
}

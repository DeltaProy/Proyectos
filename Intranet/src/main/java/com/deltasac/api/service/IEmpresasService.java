package com.deltasac.api.service;

import java.util.List;

import com.deltasac.api.entity.Empresa;

public interface IEmpresasService {

	List<Empresa> buscarTodos();
	void guardar(Empresa empresa);
	void eliminar(int idempresa);
	Empresa buscarPorId(int idEmpresa);
}

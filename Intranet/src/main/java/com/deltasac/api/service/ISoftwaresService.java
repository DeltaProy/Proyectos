package com.deltasac.api.service;

import java.util.List;

import com.deltasac.api.entity.Software;

public interface ISoftwaresService {

	List<Software> buscarTodos();
	void guardar(Software software);
	void eliminar(int idSoftware);
	Software buscarPorId(int idSoftware);
}

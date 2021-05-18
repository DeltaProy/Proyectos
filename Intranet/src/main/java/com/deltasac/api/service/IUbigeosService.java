package com.deltasac.api.service;

import java.util.List;

import com.deltasac.api.entity.Ubigeo;

public interface IUbigeosService {

	List<String> buscarDepartamentos();
	List<String> buscarProvinciasPorDep(String departamento);
	List<String> buscarDistritosPorDepProv(String departamento, String provincia);
	String buscarUbigeo(String departamento, String provincia, String distrito);
	Ubigeo buscarPorId(String idUbigeo);
}

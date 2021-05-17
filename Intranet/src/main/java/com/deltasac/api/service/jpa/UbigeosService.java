package com.deltasac.api.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deltasac.api.repository.UbigeosRepository;
import com.deltasac.api.service.IUbigeosService;

@Service
public class UbigeosService implements IUbigeosService {

	@Autowired
	private UbigeosRepository repoUbigeos;
	
	@Override
	public List<String> buscarDepartamentos() {
		return repoUbigeos.buscarDepartamentos();
	}

	@Override
	public List<String> buscarProvinciasPorDep(String departamento) {
		return repoUbigeos.buscarProvinciasPorDep(departamento);
	}

	@Override
	public List<String> buscarDistritosPorDepProv(String departamento, String provincia) {
		return repoUbigeos.buscarDistritoPorDepProv(departamento, provincia);
	}

	@Override
	public String buscarUbigeo(String departamento, String provincia, String distrito) {
		return repoUbigeos.buscarUbigeo(departamento, provincia, distrito);
	}
	
	
	
	
	


}

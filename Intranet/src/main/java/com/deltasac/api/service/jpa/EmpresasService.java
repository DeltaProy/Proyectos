package com.deltasac.api.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deltasac.api.entity.Empresa;
import com.deltasac.api.repository.EmpresasRepository;
import com.deltasac.api.service.IEmpresasService;

@Service
public class EmpresasService implements IEmpresasService {

	@Autowired
	private EmpresasRepository repoEmpresa;
	
	@Override
	public List<Empresa> buscarTodos() {
		return repoEmpresa.findAll();
	}

	@Override
	public void guardar(Empresa empresa) {
		repoEmpresa.save(empresa);
	}

	@Override
	public void eliminar(int idEmpresa) {
		repoEmpresa.deleteById(idEmpresa);
		
	}

	@Override
	public Empresa buscarPorId(int idEmpresa) {
		return repoEmpresa.findById(idEmpresa).orElse(null);
	}

}

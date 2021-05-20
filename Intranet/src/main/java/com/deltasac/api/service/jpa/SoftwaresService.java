package com.deltasac.api.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deltasac.api.entity.Software;
import com.deltasac.api.repository.SoftwaresRepository;
import com.deltasac.api.service.ISoftwaresService;

@Service
public class SoftwaresService implements ISoftwaresService {

	@Autowired
	private SoftwaresRepository repoSoftware;
	
	@Override
	public List<Software> buscarTodos() {
		return repoSoftware.findAll();
	}

	@Override
	public void guardar(Software software) {
		repoSoftware.save(software);
	}

	@Override
	public void eliminar(int idSoftware) {
		repoSoftware.deleteById(idSoftware);
		
	}

	@Override
	public Software buscarPorId(int idSoftware) {
		return repoSoftware.findById(idSoftware).orElse(null);
	}

}

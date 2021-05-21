package com.deltasac.api.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deltasac.api.entity.GesSoftware;
import com.deltasac.api.entity.GesSoftwarePK;
import com.deltasac.api.repository.GesSoftwaresRepository;
import com.deltasac.api.service.IGesSoftwaresService;

@Service
public class GesSoftwaresService implements IGesSoftwaresService{
	
	@Autowired
	private GesSoftwaresRepository repoGesSoftware;

	@Override
	public List<GesSoftware> buscarTodos() {
		return repoGesSoftware.findAll();
	}

	@Override
	public void guardar(GesSoftware gesSoftware) {
		repoGesSoftware.save(gesSoftware);
	}

	@Override
	public void eliminar(GesSoftwarePK gesSoftwarePK) {
		repoGesSoftware.deleteById(gesSoftwarePK);
	}

	@Override
	public void eliminarPorPersonal(int idPersonal) {
		repoGesSoftware.eliminarPorPersonal(idPersonal);
	}

	@Override
	public GesSoftware buscarPorId(GesSoftwarePK gesSoftwarePK) {
		return repoGesSoftware.findById(gesSoftwarePK).orElse(null);
	}

	
}

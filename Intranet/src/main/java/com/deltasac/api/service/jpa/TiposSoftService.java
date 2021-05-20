package com.deltasac.api.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deltasac.api.entity.TipoSoft;
import com.deltasac.api.repository.TiposSoftRepository;
import com.deltasac.api.service.ITiposSoftService;

@Service
public class TiposSoftService implements ITiposSoftService{
	
	@Autowired
	private TiposSoftRepository repoTipoSoft;

	@Override
	public List<TipoSoft> buscarTodos() {
		return repoTipoSoft.findAll();
	}

	@Override
	public void guardar(TipoSoft tipoSoft) {
		repoTipoSoft.save(tipoSoft);
	}

	@Override
	public void eliminar(int idTipoSoft) {
		repoTipoSoft.deleteById(idTipoSoft);
	}

	@Override
	public TipoSoft buscarPorId(int idTipoSoft) {
		return repoTipoSoft.findById(idTipoSoft).orElse(null);
	}

	

}

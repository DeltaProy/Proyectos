package com.deltasac.api.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deltasac.api.entity.TipoTelf;
import com.deltasac.api.repository.TiposTelfsRepository;
import com.deltasac.api.service.ITiposTelfsService;

@Service
public class TiposTelfsService implements ITiposTelfsService {

	@Autowired
	private TiposTelfsRepository repoTipoTelf;
	
	@Override
	public List<TipoTelf> buscarTodos() {
		return repoTipoTelf.findAll();
	}

	@Override
	public void guardar(TipoTelf tipoTelf) {
		repoTipoTelf.save(tipoTelf);
	}

	@Override
	public void eliminar(int idTipoTelf) {
		repoTipoTelf.deleteById(idTipoTelf);
		
	}

	@Override
	public TipoTelf buscarPorId(Integer idTipoTelf) {
		return repoTipoTelf.findById(idTipoTelf).orElse(null);
	}

}

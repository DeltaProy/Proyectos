package com.deltasac.api.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deltasac.api.entity.TipoEmail;
import com.deltasac.api.repository.TiposEmailsRepository;
import com.deltasac.api.service.ITiposEmailsService;

@Service
public class TiposEmailsService implements ITiposEmailsService {

	@Autowired
	private TiposEmailsRepository repoTipoEmail;
	
	@Override
	public List<TipoEmail> buscarTodos() {
		return repoTipoEmail.findAll();
	}

	@Override
	public void guardar(TipoEmail tipoemail) {
		repoTipoEmail.save(tipoemail);
	}

	@Override
	public void eliminar(int idTipoEmail) {
		repoTipoEmail.deleteById(idTipoEmail);
		
	}

	@Override
	public TipoEmail buscarPorId(Integer idTipoEmail) {
		return repoTipoEmail.findById(idTipoEmail).orElse(null);
	}

}

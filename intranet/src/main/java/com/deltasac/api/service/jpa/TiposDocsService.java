package com.deltasac.api.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deltasac.api.entity.TipoDoc;
import com.deltasac.api.repository.TiposDocsRepository;
import com.deltasac.api.service.ITiposDocsService;

@Service
public class TiposDocsService implements ITiposDocsService {

	@Autowired
	private TiposDocsRepository repoTipoDoc;
	
	@Override
	public List<TipoDoc> buscarTodos() {
		return repoTipoDoc.findAll();
	}

	@Override
	public void guardar(TipoDoc tipodoc) {
		repoTipoDoc.save(tipodoc);
	}

	@Override
	public void eliminar(int idTipoDoc) {
		repoTipoDoc.deleteById(idTipoDoc);
		
	}

}

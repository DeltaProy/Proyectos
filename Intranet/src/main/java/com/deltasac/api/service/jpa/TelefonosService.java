package com.deltasac.api.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deltasac.api.entity.Telefono;
import com.deltasac.api.entity.TelefonoPK;
import com.deltasac.api.repository.TelefonosRepository;
import com.deltasac.api.service.ITelefonosService;

@Service
public class TelefonosService implements ITelefonosService{
	
	@Autowired
	private TelefonosRepository repoTelefono;

	@Override
	public List<Telefono> buscarTodos() {
		return repoTelefono.buscarTelefonos();
	}

	@Override
	public void guardar(Telefono telefono) {
		telefono.setNrotelf(repoTelefono.buscarUltimoNrotelf(telefono.getIdpersonal()) + 1);
		repoTelefono.save(telefono);
	}

	@Override
	public void eliminar(TelefonoPK telefonoPK) throws Exception {
		Telefono telefono = repoTelefono.findById(telefonoPK).orElse(null);
		if(telefono != null && "A".equals(telefono.getEstadotelefono())) {
			telefono.setEstadotelefono("E");
			repoTelefono.save(telefono);
		}else {
			throw new Exception("Registro no existe o ya fue eliminado");
		}
	}

	@Override
	public void eliminarPorPersonal(int idPersonal) {
		repoTelefono.eliminarPorPersonal(idPersonal);
	}	

}

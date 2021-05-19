package com.deltasac.api.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deltasac.api.entity.Direccion;
import com.deltasac.api.entity.DireccionPK;
import com.deltasac.api.repository.DireccionesRepository;
import com.deltasac.api.service.IDireccionesService;

@Service
public class DireccionesService implements IDireccionesService{
	
	@Autowired
	private DireccionesRepository repoDireccion;

	@Override
	public List<Direccion> buscarTodos() {
		return repoDireccion.buscarDirecciones();
	}

	@Override
	public void guardar(Direccion direccion) {
		direccion.setNrodir(repoDireccion.buscarUltimoNrodir(direccion.getIdpersonal()) + 1);
		repoDireccion.save(direccion);
	}

	@Override
	public void eliminar(DireccionPK direccionPK) throws Exception {
		Direccion direc = repoDireccion.findById(direccionPK).orElse(null);
		if(direc != null && "A".equals(direc.getEstadodireccion())) {
			direc.setEstadodireccion("E");
			repoDireccion.save(direc);
		}else {
			throw new Exception("Registro no existe o ya fue eliminado");
		}
	}

	@Override
	public void eliminarPorPersonal(int idPersonal) {
		repoDireccion.eliminarPorPersonal(idPersonal);
	}

	
}

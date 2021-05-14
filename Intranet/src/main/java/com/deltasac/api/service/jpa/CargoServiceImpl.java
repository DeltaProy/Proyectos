package com.deltasac.api.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deltasac.api.entity.Cargo;
import com.deltasac.api.entity.CargoPK;
import com.deltasac.api.repository.CargoRepository;
import com.deltasac.api.service.ICargoService;

@Service
public class CargoServiceImpl implements ICargoService{
	
	@Autowired
	private CargoRepository repoCargo;

	@Override
	public List<Cargo> buscarTodos() {
		return repoCargo.findAll();
	}

	@Override
	public void guardar(Cargo cargo) {
		repoCargo.save(cargo);
	}

	@Override
	public void eliminar(CargoPK cargoPK) {
		repoCargo.deleteById(cargoPK);
	}

	@Override
	public Cargo buscarId(CargoPK cargoPK) {
		return repoCargo.findById(cargoPK).orElse(null);
	}

	

}

package com.deltasac.api.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deltasac.api.entity.Area;
import com.deltasac.api.repository.AreaRepository;
import com.deltasac.api.service.IAreaService;

@Service
public class AreaServiceImpl implements IAreaService{
	
	@Autowired
	private AreaRepository repoArea;

	@Override
	public List<Area> buscarTodos() {
		return repoArea.findAll();
	}

	@Override
	public void guardar(Area area) {
		repoArea.save(area);
	}

	@Override
	public void eliminar(int idArea) {
		repoArea.deleteById(idArea);
	}

	@Override
	public Area buscarId(int idArea) {
		return repoArea.findById(idArea).orElse(null);
	}

	

}

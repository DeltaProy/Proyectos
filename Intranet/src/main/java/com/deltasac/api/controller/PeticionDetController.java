package com.deltasac.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deltasac.api.entity.PeticionDet;
import com.deltasac.api.service.IPeticionDetService;

@RestController
@RequestMapping("/peticionDet")
public class PeticionDetController {

	@Autowired
	private IPeticionDetService servicePeticionDet;
	
	@GetMapping("/listar")
	public List<PeticionDet> buscarTodos(){
		return servicePeticionDet.buscarTodos();
	}
	
	@GetMapping("/listarPeticion/{idpeticion}")
	public List<PeticionDet> buscarTodos(@PathVariable("idpeticion") Integer idPeticion){
		return servicePeticionDet.buscarPorPeticion(idPeticion);
	}
	
	@PostMapping("/guardar")
	public PeticionDet guardar(@RequestBody PeticionDet peticionDet) {
		servicePeticionDet.guardar(peticionDet);
		return peticionDet;
	}
	
	@PutMapping("/actualizar")
	public PeticionDet modificar(@RequestBody PeticionDet peticionDet) {
		servicePeticionDet.guardar(peticionDet);
		return peticionDet;
	}
}

package com.deltasac.api.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deltasac.api.entity.Email;
import com.deltasac.api.entity.EmailPK;
import com.deltasac.api.repository.EmailsRepository;
import com.deltasac.api.service.IEmailsService;

@Service
public class EmailsService implements IEmailsService{
	
	@Autowired
	private EmailsRepository repoEmail;

	@Override
	public List<Email> buscarTodos() {
		return repoEmail.findAll();
	}

	@Override
	public void guardar(Email email) {
		repoEmail.save(email);
	}

	@Override
	public void eliminar(EmailPK emailPK) {
		repoEmail.deleteById(emailPK);
	}

	@Override
	public void eliminarPorPersonal(int idPersonal) {
		repoEmail.eliminarPorPersonal(idPersonal);
	}	

}

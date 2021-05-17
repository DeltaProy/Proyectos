package com.deltasac.api.service;

import java.util.List;

import com.deltasac.api.entity.Email;
import com.deltasac.api.entity.EmailPK;

public interface IEmailsService {

	List<Email> buscarTodos();
	void guardar(Email email);
	void eliminar(EmailPK emailPK);
}

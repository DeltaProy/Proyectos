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
		return repoEmail.buscarEmails();
	}

	@Override
	public void guardar(Email email) {
		email.setNroemail(repoEmail.buscarUltimoNroemail(email.getIdpersonal()) + 1);
		repoEmail.save(email);
	}

	@Override
	public void eliminar(EmailPK emailPK) throws Exception {
		Email email= repoEmail.findById(emailPK).orElse(null);
		if(email != null && "A".equals(email.getEstadoemail())) {
			email.setEstadoemail("E");
			repoEmail.save(email);
		}else {
			throw new Exception("Registro no existe o ya fue eliminado");
		}
	}

	@Override
	public void eliminarPorPersonal(int idPersonal) {
		repoEmail.eliminarPorPersonal(idPersonal);
	}	

}

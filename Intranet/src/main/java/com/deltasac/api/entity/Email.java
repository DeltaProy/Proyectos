package com.deltasac.api.entity;

import javax.persistence.*;

@Entity
@Table(name="ges_emails")
@IdClass(value = EmailPK.class)
public class Email {

	@Id
	private Integer idpersonal;
	@Id
	private Integer nroemail;
	private Integer idtipoemail;
	private String diremail;
	
	public Integer getIdpersonal() {
		return idpersonal;
	}
	public void setIdpersonal(Integer idpersonal) {
		this.idpersonal = idpersonal;
	}
	public Integer getNroemail() {
		return nroemail;
	}
	public void setNroemail(Integer nroemail) {
		this.nroemail = nroemail;
	}
	public Integer getIdtipoemail() {
		return idtipoemail;
	}
	public void setIdtipoemail(Integer idtipoemail) {
		this.idtipoemail = idtipoemail;
	}
	public String getDiremail() {
		return diremail;
	}
	public void setDiremail(String diremail) {
		this.diremail = diremail;
	}
	
	@Override
	public String toString() {
		return "Email [idpersonal=" + idpersonal + ", nroemail=" + nroemail + ", idtipoemail=" + idtipoemail
				+ ", diremail=" + diremail + "]";
	}
			
}
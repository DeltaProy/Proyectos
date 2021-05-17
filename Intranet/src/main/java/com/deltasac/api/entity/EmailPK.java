package com.deltasac.api.entity;

import java.io.Serializable;

public class EmailPK implements Serializable{
    private Integer idpersonal;
	private Integer nroemail;
	
	public EmailPK() {
		super();
	}

	public EmailPK(Integer idpersonal, Integer nroemail) {
		super();
		this.idpersonal = idpersonal;
		this.nroemail = nroemail;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idpersonal == null) ? 0 : idpersonal.hashCode());
		result = prime * result + ((nroemail == null) ? 0 : nroemail.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmailPK other = (EmailPK) obj;
		if (idpersonal == null) {
			if (other.idpersonal != null)
				return false;
		} else if (!idpersonal.equals(other.idpersonal))
			return false;
		if (nroemail == null) {
			if (other.nroemail != null)
				return false;
		} else if (!nroemail.equals(other.nroemail))
			return false;
		return true;
	}

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

	@Override
	public String toString() {
		return "DireccionPK [idpersonal=" + idpersonal + ", nroemail=" + nroemail + "]";
	}
	
	
	
	
}

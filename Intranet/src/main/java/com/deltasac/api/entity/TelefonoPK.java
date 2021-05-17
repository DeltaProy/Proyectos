package com.deltasac.api.entity;

import java.io.Serializable;

public class TelefonoPK implements Serializable{
    private Integer idpersonal;
	private Integer nrotelf;
	
	public TelefonoPK() {
		super();
	}

	public TelefonoPK(Integer idpersonal, Integer nrotelf) {
		super();
		this.idpersonal = idpersonal;
		this.nrotelf = nrotelf;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idpersonal == null) ? 0 : idpersonal.hashCode());
		result = prime * result + ((nrotelf == null) ? 0 : nrotelf.hashCode());
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
		TelefonoPK other = (TelefonoPK) obj;
		if (idpersonal == null) {
			if (other.idpersonal != null)
				return false;
		} else if (!idpersonal.equals(other.idpersonal))
			return false;
		if (nrotelf == null) {
			if (other.nrotelf != null)
				return false;
		} else if (!nrotelf.equals(other.nrotelf))
			return false;
		return true;
	}

	public Integer getIdpersonal() {
		return idpersonal;
	}

	public void setIdpersonal(Integer idpersonal) {
		this.idpersonal = idpersonal;
	}

	public Integer getNrotelf() {
		return nrotelf;
	}

	public void setNrotelf(Integer nrotelf) {
		this.nrotelf = nrotelf;
	}

	@Override
	public String toString() {
		return "TelefonoPK [idpersonal=" + idpersonal + ", nrotelf=" + nrotelf + "]";
	}

	
	
	
	
	
}

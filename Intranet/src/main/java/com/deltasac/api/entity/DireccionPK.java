package com.deltasac.api.entity;

import java.io.Serializable;

public class DireccionPK implements Serializable{
    private Integer idpersonal;
	private Integer nrodir;
	
	public DireccionPK() {
		super();
	}

	public DireccionPK(Integer idpersonal, Integer nrodir) {
		super();
		this.idpersonal = idpersonal;
		this.nrodir = nrodir;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idpersonal == null) ? 0 : idpersonal.hashCode());
		result = prime * result + ((nrodir == null) ? 0 : nrodir.hashCode());
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
		DireccionPK other = (DireccionPK) obj;
		if (idpersonal == null) {
			if (other.idpersonal != null)
				return false;
		} else if (!idpersonal.equals(other.idpersonal))
			return false;
		if (nrodir == null) {
			if (other.nrodir != null)
				return false;
		} else if (!nrodir.equals(other.nrodir))
			return false;
		return true;
	}

	public Integer getIdpersonal() {
		return idpersonal;
	}

	public void setIdpersonal(Integer idpersonal) {
		this.idpersonal = idpersonal;
	}

	public Integer getNrodir() {
		return nrodir;
	}

	public void setNrodir(Integer nrodir) {
		this.nrodir = nrodir;
	}

	@Override
	public String toString() {
		return "DireccionPK [idpersonal=" + idpersonal + ", nrodir=" + nrodir + "]";
	}
	
	
	
	
}

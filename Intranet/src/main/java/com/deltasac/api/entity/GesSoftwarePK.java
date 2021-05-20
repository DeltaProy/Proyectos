package com.deltasac.api.entity;

import java.io.Serializable;

public class GesSoftwarePK implements Serializable{
    private Integer idpersonal;
	private Integer idsoft;
	
	public GesSoftwarePK() {
		super();
	}
	
	public GesSoftwarePK(Integer idpersonal, Integer idsoft) {
		super();
		this.idpersonal = idpersonal;
		this.idsoft = idsoft;
	} 
	 
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idpersonal == null) ? 0 : idpersonal.hashCode());
		result = prime * result + ((idsoft == null) ? 0 : idsoft.hashCode());
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
		GesSoftwarePK other = (GesSoftwarePK) obj;
		if (idpersonal == null) {
			if (other.idpersonal != null)
				return false;
		} else if (!idpersonal.equals(other.idpersonal))
			return false;
		if (idsoft == null) {
			if (other.idsoft != null)
				return false;
		} else if (!idsoft.equals(other.idsoft))
			return false;
		return true;
	}
	
	public Integer getIdpersonal() {
		return idpersonal;
	}
	public void setIdpersonal(Integer idpersonal) {
		this.idpersonal = idpersonal;
	}
	public Integer getIdsoft() {
		return idsoft;
	}
	public void setIdsoft(Integer idsoft) {
		this.idsoft = idsoft;
	}
	
	@Override
	public String toString() {
		return "GesSoftwarePK [idpersonal=" + idpersonal + ", idsoft=" + idsoft + "]";
	}
	
	
	
	
	
	
	
	
}

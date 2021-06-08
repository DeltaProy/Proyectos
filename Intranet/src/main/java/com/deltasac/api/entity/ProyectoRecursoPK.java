package com.deltasac.api.entity;

import java.io.Serializable;

public class ProyectoRecursoPK implements Serializable{
    private Integer idproyecto;
	private Integer idpersonal;
	
	public ProyectoRecursoPK() {
		super();
	}
	
	public ProyectoRecursoPK(Integer idproyecto, Integer idpersonal) {
		super();
		this.idproyecto = idproyecto;
		this.idpersonal = idpersonal;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idpersonal == null) ? 0 : idpersonal.hashCode());
		result = prime * result + ((idproyecto == null) ? 0 : idproyecto.hashCode());
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
		ProyectoRecursoPK other = (ProyectoRecursoPK) obj;
		if (idpersonal == null) {
			if (other.idpersonal != null)
				return false;
		} else if (!idpersonal.equals(other.idpersonal))
			return false;
		if (idproyecto == null) {
			if (other.idproyecto != null)
				return false;
		} else if (!idproyecto.equals(other.idproyecto))
			return false;
		return true;
	}
	
	public Integer getIdproyecto() {
		return idproyecto;
	}
	public void setIdproyecto(Integer idproyecto) {
		this.idproyecto = idproyecto;
	}
	public Integer getIdpersonal() {
		return idpersonal;
	}
	public void setIdpersonal(Integer idpersonal) {
		this.idpersonal = idpersonal;
	}
	
	@Override
	public String toString() {
		return "ProyectoRecursoPK [idproyecto=" + idproyecto + ", idpersonal=" + idpersonal + "]";
	}
}

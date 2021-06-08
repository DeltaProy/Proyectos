package com.deltasac.api.entity;

import java.io.Serializable;

public class ProyectoTareaPK implements Serializable{
    private Integer idproyecto;
	private Integer idpersonal;
	private Integer numtarea;
	
	public ProyectoTareaPK() {
		super();
	}

	public ProyectoTareaPK(Integer idproyecto, Integer idpersonal, Integer numtarea) {
		super();
		this.idproyecto = idproyecto;
		this.idpersonal = idpersonal;
		this.numtarea = numtarea;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idpersonal == null) ? 0 : idpersonal.hashCode());
		result = prime * result + ((idproyecto == null) ? 0 : idproyecto.hashCode());
		result = prime * result + ((numtarea == null) ? 0 : numtarea.hashCode());
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
		ProyectoTareaPK other = (ProyectoTareaPK) obj;
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
		if (numtarea == null) {
			if (other.numtarea != null)
				return false;
		} else if (!numtarea.equals(other.numtarea))
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

	public Integer getNumtarea() {
		return numtarea;
	}

	public void setNumtarea(Integer numtarea) {
		this.numtarea = numtarea;
	}

	@Override
	public String toString() {
		return "ProyectoTareaPK [idproyecto=" + idproyecto + ", idpersonal=" + idpersonal + ", numtarea=" + numtarea
				+ "]";
	}
	
}

package com.deltasac.api.entity;

import java.io.Serializable;

public class ProyectoHomologadoPK implements Serializable{
    private Integer idproyecto;
	private String nomcorto;
	
	public ProyectoHomologadoPK() {
		super();
	}
	public ProyectoHomologadoPK(Integer idproyecto, String nomcorto) {
		super();
		this.idproyecto = idproyecto;
		this.nomcorto = nomcorto;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idproyecto == null) ? 0 : idproyecto.hashCode());
		result = prime * result + ((nomcorto == null) ? 0 : nomcorto.hashCode());
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
		ProyectoHomologadoPK other = (ProyectoHomologadoPK) obj;
		if (idproyecto == null) {
			if (other.idproyecto != null)
				return false;
		} else if (!idproyecto.equals(other.idproyecto))
			return false;
		if (nomcorto == null) {
			if (other.nomcorto != null)
				return false;
		} else if (!nomcorto.equals(other.nomcorto))
			return false;
		return true;
	}
	public Integer getIdproyecto() {
		return idproyecto;
	}
	public void setIdproyecto(Integer idproyecto) {
		this.idproyecto = idproyecto;
	}
	public String getNomcorto() {
		return nomcorto;
	}
	public void setNomcorto(String nomcorto) {
		this.nomcorto = nomcorto;
	}
	@Override
	public String toString() {
		return "ProyectoHomologadoPK [idproyecto=" + idproyecto + ", nomcorto=" + nomcorto + "]";
	}
	
	
}

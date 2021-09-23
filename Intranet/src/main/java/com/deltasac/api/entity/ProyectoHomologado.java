package com.deltasac.api.entity;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="ges_proy_homolog")
@IdClass(value = ProyectoHomologadoPK.class)
public class ProyectoHomologado {

	@Id
	private Integer idproyecto;
	@Id
	private String nomcorto;
	private Integer idpersonal;
	
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
	public Integer getIdpersonal() {
		return idpersonal;
	}
	public void setIdpersonal(Integer idpersonal) {
		this.idpersonal = idpersonal;
	}
	@Override
	public String toString() {
		return "ProyectoHomologado [idproyecto=" + idproyecto + ", nomcorto=" + nomcorto + ", idpersonal=" + idpersonal
				+ "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idpersonal == null) ? 0 : idpersonal.hashCode());
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
		ProyectoHomologado other = (ProyectoHomologado) obj;
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
		if (nomcorto == null) {
			if (other.nomcorto != null)
				return false;
		} else if (!nomcorto.equals(other.nomcorto))
			return false;
		return true;
	}
	
	
	
}

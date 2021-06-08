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
	
	
}

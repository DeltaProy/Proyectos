package com.deltasac.api.entity;

import javax.persistence.*;

@Entity
@Table(name="ges_software")
@IdClass(value = GesSoftwarePK.class)
public class GesSoftware {

	@Id
	private Integer idpersonal;
	@Id
	@Column(name = "id_soft")
	private Integer idsoft;
	private Integer nivel;
	private String certificado;
	
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
	public Integer getNivel() {
		return nivel;
	}
	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}
	public String getCertificado() {
		return certificado;
	}
	public void setCertificado(String certificado) {
		this.certificado = certificado;
	}
	
	@Override
	public String toString() {
		return "GesSoftware [idpersonal=" + idpersonal + ", idsoft=" + idsoft + ", nivel=" + nivel + ", certificado="
				+ certificado + "]";
	}
			
}
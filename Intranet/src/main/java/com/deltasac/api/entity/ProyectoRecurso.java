package com.deltasac.api.entity;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="ges_proy_recursos")
@IdClass(value = ProyectoRecursoPK.class)
public class ProyectoRecurso {

	@Id
	private Integer idproyecto;
	@Id
	private Integer idpersonal;
	private String tipo_recurso;
	private Date fecini_lab;
	private Date fecfin_lab;
	private Date fecfin_real;
	
	
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
	public String getTipo_recurso() {
		return tipo_recurso;
	}
	public void setTipo_recurso(String tipo_recurso) {
		this.tipo_recurso = tipo_recurso;
	}
	public Date getFecini_lab() {
		return fecini_lab;
	}
	public void setFecini_lab(Date fecini_lab) {
		this.fecini_lab = fecini_lab;
	}
	public Date getFecfin_lab() {
		return fecfin_lab;
	}
	public void setFecfin_lab(Date fecfin_lab) {
		this.fecfin_lab = fecfin_lab;
	}
	public Date getFecfin_real() {
		return fecfin_real;
	}
	public void setFecfin_real(Date fecfin_real) {
		this.fecfin_real = fecfin_real;
	}
	
	@Override
	public String toString() {
		return "ProyectoRecurso [idproyecto=" + idproyecto + ", idpersonal=" + idpersonal + ", tipo_recurso="
				+ tipo_recurso + ", fecini_lab=" + fecini_lab + ", fecfin_lab=" + fecfin_lab + ", fecfin_real="
				+ fecfin_real + "]";
	}
}

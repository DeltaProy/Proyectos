package com.deltasac.api.entity;

import java.util.Date;

import javax.persistence.*;

import com.sun.istack.Nullable;

@Entity
@Table(name="ges_proy_tareas")
@IdClass(value = ProyectoTareaPK.class)
public class ProyectoTarea {
	
	@Id
	private Integer idproyecto;
	@Id
	private Integer idpersonal;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer numtarea;
	private String destarea;
	private Date fecini;
	private Date fecfin;
	private Date fecfin_real;
	private Double porc_avance;
	
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
	public String getDestarea() {
		return destarea;
	}
	public void setDestarea(String destarea) {
		this.destarea = destarea;
	}
	public Date getFecini() {
		return fecini;
	}
	public void setFecini(Date fecini) {
		this.fecini = fecini;
	}
	public Date getFecfin() {
		return fecfin;
	}
	public void setFecfin(Date fecfin) {
		this.fecfin = fecfin;
	}
	public Date getFecfin_real() {
		return fecfin_real;
	}
	public void setFecfin_real(Date fecfin_real) {
		this.fecfin_real = fecfin_real;
	}
	public Double getPorc_avance() {
		return porc_avance;
	}
	public void setPorc_avance(Double porc_avance) {
		this.porc_avance = porc_avance;
	}
	@Override
	public String toString() {
		return "ProyectoTarea [idproyecto=" + idproyecto + ", idpersonal=" + idpersonal + ", numtarea=" + numtarea
				+ ", destarea=" + destarea + ", fecini=" + fecini + ", fecfin=" + fecfin + ", fecfin_real="
				+ fecfin_real + ", porc_avance=" + porc_avance + "]";
	}
	
	
}

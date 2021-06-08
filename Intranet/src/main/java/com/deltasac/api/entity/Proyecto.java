package com.deltasac.api.entity;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="ges_proyectos")
public class Proyecto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idproyecto;
	private String desproyecto;
	private Date fecini;
	private Date fecfin;
	private Date fecfinreal;
	private Integer idEmpresa;
	
	
	public Integer getIdproyecto() {
		return idproyecto;
	}
	public void setIdproyecto(Integer idproyecto) {
		this.idproyecto = idproyecto;
	}
	public String getDesproyecto() {
		return desproyecto;
	}
	public void setDesproyecto(String desproyecto) {
		this.desproyecto = desproyecto;
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
	public Date getFecfinreal() {
		return fecfinreal;
	}
	public void setFecfinreal(Date fecfinreal) {
		this.fecfinreal = fecfinreal;
	}
	public Integer getIdEmpresa() {
		return idEmpresa;
	}
	public void setIdEmpresa(Integer idEmpresa) {
		this.idEmpresa = idEmpresa;
	}
	@Override
	public String toString() {
		return "Proyectos [idproyecto=" + idproyecto + ", desproyecto=" + desproyecto + ", fecini=" + fecini
				+ ", fecfin=" + fecfin + ", fecfinreal=" + fecfinreal + ", idEmpresa=" + idEmpresa + "]";
	}
	
		
}

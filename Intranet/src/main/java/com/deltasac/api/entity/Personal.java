package com.deltasac.api.entity;

import javax.persistence.*;

@Entity
@Table(name="ges_personal")
public class Personal {

	@Id
	private Integer idpersonal;
	private Integer idtipodoc;
	private String nrodoc;
	private String nomper;
	private String apeper;
	private Integer idempresa;
	private Integer idarea;
	private Integer idcargo;
	
	public Integer getIdpersonal() {
		return idpersonal;
	}
	public void setIdpersonal(Integer idpersonal) {
		this.idpersonal = idpersonal;
	}
	public Integer getIdtipodoc() {
		return idtipodoc;
	}
	public void setIdtipodoc(Integer idtipodoc) {
		this.idtipodoc = idtipodoc;
	}
	public String getNrodoc() {
		return nrodoc;
	}
	public void setNrodoc(String nrodoc) {
		this.nrodoc = nrodoc;
	}
	public String getNomper() {
		return nomper;
	}
	public void setNomper(String nomper) {
		this.nomper = nomper;
	}
	public String getApeper() {
		return apeper;
	}
	public void setApeper(String apeper) {
		this.apeper = apeper;
	}
	public Integer getIdempresa() {
		return idempresa;
	}
	public void setIdempresa(Integer idempresa) {
		this.idempresa = idempresa;
	}
	public Integer getIdarea() {
		return idarea;
	}
	public void setIdarea(Integer idarea) {
		this.idarea = idarea;
	}
	public Integer getIdcargo() {
		return idcargo;
	}
	public void setIdcargo(Integer idcargo) {
		this.idcargo = idcargo;
	}
	
	@Override
	public String toString() {
		return "Personal [idpersonal=" + idpersonal + ", idtipodoc=" + idtipodoc + ", nrodoc=" + nrodoc + ", nomper="
				+ nomper + ", apeper=" + apeper + ", idempresa=" + idempresa + ", idarea=" + idarea + ", idcargo="
				+ idcargo + "]";
	}
	
	
	
	
	
	
}

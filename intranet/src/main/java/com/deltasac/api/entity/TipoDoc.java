package com.deltasac.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mae_tipos_docs")
public class TipoDoc {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idtipodoc;
	private String descortipodoc;
	private String deslartipodoc;
	
	public Integer getIdtipodoc() {
		return idtipodoc;
	}
	public void setIdtipodoc(Integer idtipodoc) {
		this.idtipodoc = idtipodoc;
	}
	public String getDescortipodoc() {
		return descortipodoc;
	}
	public void setDescortipodoc(String descortipodoc) {
		this.descortipodoc = descortipodoc;
	}
	public String getDeslartipodoc() {
		return deslartipodoc;
	}
	public void setDeslartipodoc(String deslartipodoc) {
		this.deslartipodoc = deslartipodoc;
	}
	
	@Override
	public String toString() {
		return "TipoDoc [idtipodoc=" + idtipodoc + ", descortipodoc=" + descortipodoc + ", deslartipodoc="
				+ deslartipodoc + "]";
	}
	
	
	
	
	
}

package com.deltasac.api.entity;

import javax.persistence.*;

@Entity
@Table(name="mae_empresas")
public class Empresa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_empresa")
	private Integer idempresa;
	@Column(name="razon_social")
	private String razonsocial;
	@Column(name="nro_ruc")
	private String nroruc;
	
	
	public Integer getIdempresa() {
		return idempresa;
	}
	public void setIdempresa(Integer idempresa) {
		this.idempresa = idempresa;
	}
	public String getRazonsocial() {
		return razonsocial;
	}
	public void setRazonsocial(String razonsocial) {
		this.razonsocial = razonsocial;
	}
	public String getNroruc() {
		return nroruc;
	}
	public void setNroruc(String nroruc) {
		this.nroruc = nroruc;
	}
	
	
	@Override
	public String toString() {
		return "Empresa [idempresa=" + idempresa + ", razonsocial=" + razonsocial + ", nroruc=" + nroruc + "]";
	}
	
}

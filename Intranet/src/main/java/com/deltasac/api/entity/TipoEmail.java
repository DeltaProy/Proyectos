package com.deltasac.api.entity;

import javax.persistence.*;

@Entity
@Table(name="mae_tipos_emails")
public class TipoEmail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idtipoemail;
	private String destipoemail;
	
	public Integer getIdtipoemail() {
		return idtipoemail;
	}
	public void setIdtipoemail(Integer idtipoemail) {
		this.idtipoemail = idtipoemail;
	}
	public String getDestipoemail() {
		return destipoemail;
	}
	public void setDestipoemail(String destipoemail) {
		this.destipoemail = destipoemail;
	}
	
	@Override
	public String toString() {
		return "TipoEmail [idtipoemail=" + idtipoemail + ", destipoemail=" + destipoemail + "]";
	}
	
		
	
}
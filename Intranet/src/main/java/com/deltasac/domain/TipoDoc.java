package com.deltasac.domain;

import java.io.Serializable;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "mae_tipos_docs")
public class TipoDoc implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTipoDoc;
	
	private String desCorTipoDoc;

	private String desLarTipoDoc;
}

package com.deltasac.api.property;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "file")
public class FileStorageProperties {
	private String certificados;
	private String fotospersonal;
	
	public String getCertificados() {
		return certificados;
	}
	public void setCertificados(String certificados) {
		this.certificados = certificados;
	}
	public String getFotospersonal() {
		return fotospersonal;
	}
	public void setFotospersonal(String fotospersonal) {
		this.fotospersonal = fotospersonal;
	}
	
	
}

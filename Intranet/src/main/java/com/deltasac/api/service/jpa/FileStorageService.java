package com.deltasac.api.service.jpa;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.util.StringUtils;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import com.deltasac.api.property.FileStorageProperties;


@Service
public class FileStorageService{
	
	private final Path pathCertificados;
	private final Path pathFotosPersonal;
	
	@Autowired
	public FileStorageService(FileStorageProperties fsprop) {
		this.pathCertificados = Paths.get(fsprop.getCertificados()).toAbsolutePath().normalize();
		this.pathFotosPersonal= Paths.get(fsprop.getFotospersonal()).toAbsolutePath().normalize();
	}

	//FOTOS CERFTIFICADOS
	public String uploadCertificado(MultipartFile file) {
				
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());			
		
		try {
			
			Path targetLocation = this.pathCertificados.resolve(fileName);
			Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}

        return fileName;
	}
	
	
	public Resource getCertificado(String fileName) {
		try {
			Path filePath = this.pathCertificados.resolve(fileName).normalize();
			Resource recurso = new UrlResource(filePath.toUri());
			
			
			if(recurso.exists()) {
				return recurso;
			}else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	
	//FOTOS PERSONAL

	public String uploadFotoPersonal(MultipartFile file) {
		
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());			
		
		try {
			
			Path targetLocation = this.pathFotosPersonal.resolve(fileName);
			Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}

        return fileName;
	}
	
	
	public Resource getFotoPersonal(String fileName) {
		try {
			Path filePath = this.pathFotosPersonal.resolve(fileName).normalize();
			Resource recurso = new UrlResource(filePath.toUri());
			
			
			if(recurso.exists()) {
				return recurso;
			}else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
}

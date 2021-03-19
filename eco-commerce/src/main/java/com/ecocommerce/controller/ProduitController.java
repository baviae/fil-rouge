package com.ecocommerce.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ecocommerce.DTO.ProduitDTO;
import com.ecocommerce.IService.IProduitService;

@RestController
public class ProduitController {
	
	@Autowired
	IProduitService produitService;
	
	@GetMapping("produits")
	public List<ProduitDTO> produisList(){
		return this.produitService.afficherListeProduit();
	}
	
	@PostMapping("produit")
	public ProduitDTO ajoutProduit(@RequestBody ProduitDTO dto) {
		return this.produitService.ajouterProduit(dto);
	}
	
	@PostMapping("produits/image")
	public ResponseEntity<InputStreamResource> getImageProduit(@RequestBody ProduitDTO dto) {

			try {
				File theCsv = new File("src/main/resources/static/image/" + dto.getId() + "."+ dto.getImage().split("\\.")[1]);
				HttpHeaders respHeaders = new HttpHeaders();
	            MediaType mediaType = new MediaType("image",dto.getImage().split("\\.")[1]);
	            respHeaders.setContentType(mediaType);
	            respHeaders.setContentDispositionFormData("attachment", dto.getId() + "."+ dto.getImage().split("\\.")[1]);
	            InputStreamResource isr = new InputStreamResource(new FileInputStream(theCsv));
	            return new ResponseEntity<InputStreamResource>(isr, respHeaders, HttpStatus.OK);
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				return null;
			}
		
		
	}
	
	@PostMapping("image/{id}")
	public String handleFileUpload(@PathVariable("id") String produitId,@RequestParam("file") MultipartFile file) throws IOException {
		ProduitDTO prdDto = this.produitService.getProduitBuyId(Long.parseLong(produitId));
		if (file.getOriginalFilename().equals("jpg")) {
			prdDto.setImage("jpeg");
		}else {
			prdDto.setImage(file.getOriginalFilename());
		}
		
		this.produitService.updateprd(prdDto);
		System.out.println(file.getOriginalFilename());
		File filez = new File("src/main/resources/static/image/"+produitId+"."+file.getContentType().split("/")[1]);
	      try (FileOutputStream fosFor = new FileOutputStream(filez)) {
	      fosFor.write(file.getBytes());
	    }
		return "ok";
	}
	
	

}

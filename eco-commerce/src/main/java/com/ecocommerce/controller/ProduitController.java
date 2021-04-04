package com.ecocommerce.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
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
	
	@GetMapping(value = "produits/image/{idPrd}/{type}", produces = MediaType.IMAGE_JPEG_VALUE)
	public ResponseEntity<byte[]> getImageProduit(@PathVariable("idPrd") String idPrd,@PathVariable("type") String type) throws IOException {
				Path filez = Paths.get("src/main/resources/static/image/" + idPrd + "."+ type.split("\\.")[1]);
	            return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(Files.readAllBytes(filez));
	}
	
	@PostMapping("image/{id}")
	public String handleFileUpload(@PathVariable("id") String produitId,@RequestParam("file") MultipartFile file) throws IOException {
		ProduitDTO prdDto = this.produitService.getProduitBuyId(Long.parseLong(produitId));
		if (file.getOriginalFilename().contains("jpg")) {
			prdDto.setImage(file.getOriginalFilename().split("\\.")[0] +"."+"jpeg");
		}else {
			prdDto.setImage(file.getOriginalFilename());
		}
		
		this.produitService.updateprd(prdDto);
		System.out.println(file.getOriginalFilename());
		File filez = new File("src/main/resources/static/image/"+produitId+"."+prdDto.getImage().split("\\.")[1]);
	      try (FileOutputStream fosFor = new FileOutputStream(filez)) {
	      fosFor.write(file.getBytes());
	    }
		return "ok";
	}
	
	

}

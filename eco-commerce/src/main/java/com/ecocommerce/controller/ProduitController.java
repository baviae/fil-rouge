package com.ecocommerce.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.azure.core.annotation.Delete;
import com.ecocommerce.DTO.ProduitDTO;
import com.ecocommerce.IService.IProduitService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("api/")
public class ProduitController {
	
	private static Logger logger = LoggerFactory.getLogger(ProduitController.class);
	
	@Autowired
	IProduitService produitService;
	
	@GetMapping("produits")
	public List<ProduitDTO> produisList(){
		logger.info("get all produit");
		return this.produitService.afficherListeProduit();
	}
	
	@PostMapping("produit")
	public ProduitDTO ajoutProduit(@RequestBody ProduitDTO dto) {
		logger.info("save a produit");
		return this.produitService.ajouterProduit(dto);
	}
	
	@GetMapping(value = "produits/image/{idPrd}/{type}", produces = MediaType.IMAGE_JPEG_VALUE)
	public ResponseEntity<byte[]> getImageProduit(@PathVariable("idPrd") String idPrd,@PathVariable("type") String type) throws IOException {
		Path filez = Paths.get("app/image/" + idPrd + "."+ type.split("\\.")[1]);
		logger.info("get image produit");
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
		logger.info("Save image produit");
		File filez = new File("app/image/"+produitId+"."+prdDto.getImage().split("\\.")[1]);
	      try (FileOutputStream fosFor = new FileOutputStream(filez)) {
	      fosFor.write(file.getBytes());
	    }
		return "ok";
	}
	

}

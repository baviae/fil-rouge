package com.ecocommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
	
	

}

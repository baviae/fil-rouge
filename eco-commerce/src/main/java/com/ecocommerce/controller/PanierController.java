package com.ecocommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ecocommerce.DTO.PanierDTO;
import com.ecocommerce.IService.IPanierService;
import com.ecocommerce.IService.IProduitService;
import com.ecocommerce.IService.IUserService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("api/")
public class PanierController {
	
	@Autowired
	IPanierService panierService;
	
	@Autowired
	IProduitService produitService;
	
	
	@Autowired
	IUserService userService;
	
	
	@GetMapping("panier/{userId}")
	public ResponseEntity<PanierDTO> getPanierUser(@PathVariable("userId") Long userId){
		return new ResponseEntity<PanierDTO>( this.panierService.getpanierByUserId(userId),HttpStatus.OK);
	}
	
	
	@PostMapping("panier/{userId}/{idPrd}")
	public ResponseEntity<PanierDTO> ajoutdansPanier(@PathVariable("userId") Long userId, @PathVariable ("idPrd") Long idPrd ){
		return new ResponseEntity<PanierDTO>(this.panierService.ajouterPanier(userId, idPrd),HttpStatus.OK);
	}
	
	
	@DeleteMapping("panier/{panId}/{prdId}")
	public void supprimerUnProduit(@PathVariable("panId") Long panId,@PathVariable("prdId") Long prdId) {
		this.panierService.SupprimerUnProduitDuPanier(panId, prdId);
	}
	
	@DeleteMapping("viderpanier/{panId}")
	public void viderPanier(@PathVariable("panId") Long panId) {
		this.panierService.SupprimerPanier(panId);
	}
	

}

package com.ecocommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ecocommerce.DTO.PanierDTO;
import com.ecocommerce.DTO.UserDTO;
import com.ecocommerce.IService.IPanierService;
import com.ecocommerce.IService.IProduitService;
import com.ecocommerce.IService.IUserService;


@RestController
public class PanierController {
	
	@Autowired
	IPanierService panierService;
	
	@Autowired
	IProduitService produitService;
	
	
	@Autowired
	IUserService userService;
	
	
	
	@GetMapping("panier/{id}")
	public ResponseEntity<PanierDTO> getPanierUser(@PathVariable("id") Long userId){
		return new ResponseEntity<PanierDTO>( this.userService.getUserByHisId(userId).getPanierDto(),HttpStatus.OK);
	}
	
	
	@PostMapping("panier/{id}")
	public ResponseEntity<PanierDTO> ajoutdansPanier(@PathVariable("id") Long userId, @RequestBody PanierDTO panierDto){
		UserDTO userDto = this.userService.getUserByHisId(userId);
		return new ResponseEntity<PanierDTO>(this.panierService.ajouterPanier(userDto.getPanierDto().getId(), panierDto),HttpStatus.OK);
		
	}
	
	
	@DeleteMapping("panier/{panId}/{prdId}")
	public String supprimerUnProduit(@PathVariable("panId") Long panId,@PathVariable("prdId") Long prdId) {
		return this.panierService.SupprimerUnProduitDuPanier(panId, prdId);
	}
	
	@DeleteMapping("panier/{panId}/{prdId}")
	public String viderPanier(@PathVariable("panId") Long panId) {
		return this.panierService.SupprimerPanier(panId);
	}
	

}

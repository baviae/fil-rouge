package com.ecocommerce.controller;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ecocommerce.DTO.PanierDTO;
import com.ecocommerce.DTO.ProduitDTO;
import com.ecocommerce.DTO.UserDTO;
import com.ecocommerce.Entity.Panier;
import com.ecocommerce.Entity.Produit;
import com.ecocommerce.service.UserService;
import com.ecocommerce.utile.JwtGetToken;
import com.ecocommerce.utile.MyUserPrincipal;


@RestController
public class UserController {
	
	@Autowired
	UserService userService;

	@Autowired
	private AuthenticationManager authenticationManager;
		
	
	@PostMapping("/SignIn")
	public UserDTO inscription(@RequestBody UserDTO userDTO) {
		return this.userService.saveUser(userDTO);
	}
	
	@PostMapping("/login")
	public ResponseEntity<UserDTO> login(@RequestBody UserDTO userDTO) {
		
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
				userDTO.getEmail(), userDTO.getPassword());
		Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

		MyUserPrincipal us  = (MyUserPrincipal) authentication.getPrincipal();
		
		
		if (authentication != null && authentication.isAuthenticated()) {
			String token = JwtGetToken.getJWTToken(userDTO.getEmail());
			userDTO.setId(us.getUser().getId());
			if (us.getUser().getPanier() != null) {
				userDTO.setPanierDto(this.panierToPanierDTO(us.getUser().getPanier()));
			}
			userDTO.setNom(us.getUser().getNom());
			userDTO.setPrenom(us.getUser().getPrenom());
			userDTO.setToken(token);
			userDTO.setPassword(null);
			return new ResponseEntity<UserDTO>(userDTO,HttpStatus.OK);
		}

		return null;
		
	}
	

	
	@GetMapping("/deconnexion")
	public void controleurDeconnection(HttpServletRequest request,HttpServletResponse res) throws IOException {
		request.getSession().invalidate();
		res.sendRedirect("/login");
	}


	@GetMapping("/utilisateurs")
	public List<UserDTO> listeUser(){
		return this.userService.listeUsers();
	}
	
	
	
	
	
	public PanierDTO panierToPanierDTO(Panier pan) {
		return PanierDTO.builder()
		.id(pan.getId())
		.produits(pan.getProduits()
				.stream()
				.map(x -> this.produitToProduitDTO(x)).collect(Collectors.toList())).build();
	}
	
	public Panier panierDTOToPanier(PanierDTO pan) {
		return Panier.builder()
		.id(pan.getId())
		.produits(pan.getProduits()
				.stream()
				.map(x -> this.produitDtoToProduit(x)).collect(Collectors.toList())).build();
	}
	
	
	private ProduitDTO produitToProduitDTO(Produit prd){
		return ProduitDTO.builder()
				.id(prd.getId())
				.image(prd.getImage())
				.nom(prd.getNom())
				.prix(prd.getPrix())
				.description(prd.getDescription()).build();
	}
	
	private Produit produitDtoToProduit(ProduitDTO prd){
		return Produit.builder()
				.image(prd.getImage())
				.nom(prd.getNom())
				.prix(prd.getPrix())
				.description(prd.getDescription()).build();
	}

}

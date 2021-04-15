package com.ecocommerce.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecocommerce.DAO.IPanierDao;
import com.ecocommerce.DAO.ProduitDao;
import com.ecocommerce.DAO.UserDao;
import com.ecocommerce.DTO.PanierDTO;
import com.ecocommerce.DTO.ProduitDTO;
import com.ecocommerce.DTO.UserDTO;
import com.ecocommerce.Entity.Panier;
import com.ecocommerce.Entity.Produit;
import com.ecocommerce.Entity.Users;
import com.ecocommerce.IService.IPanierService;

@Service
public class PanierService implements IPanierService{
	

	@Autowired
	UserDao userDao;
	
	@Autowired
	IPanierDao panierDao;
	
	@Autowired
	ProduitDao produitDao;
	

	@Override
	public List<PanierDTO> afficherListePanier() {
		return null;
	}
	

	@Override
	public PanierDTO getpanierByUserId(Long userId) {
		Optional<Users> user = this.userDao.findById(userId);
		System.out.println("*********  "+user.get());
		if (user.isPresent()) {
			Panier panier = user.get().getPanier();
			if (panier == null) {
				panier = new Panier();
				//panier.setProduits(new ArrayList<Produit>());
				user.get().setPanier(panier);
				panierDao.save(panier);
			}
			return this.panierToPanierDTO(panier);
		} else {
			return null;
		}
	}

	@Override
	public String SupprimerPanier(Long id) {
		Optional<Panier> opPan = this.panierDao.findById(id);
		if (opPan.isPresent()) {
			opPan.get().getProduits().clear();
			this.panierDao.save(opPan.get());
			return "ok";
		}else {
			return null;
		}
	}

	@Override
	public PanierDTO ajouterPanier(Long idUser, Long idPrd) {
		Optional<Users> user = this.userDao.findById(idUser);
		if (user.isEmpty()) return null;
		Panier panierUtilisateur = user.get().getPanier();
		if(panierUtilisateur == null) {
			panierUtilisateur = new Panier();
		}
		if(panierUtilisateur.getProduits() == null) {
			panierUtilisateur.setProduits(new ArrayList<Produit>());
		}
		Optional<Produit> produit = produitDao.findById(idPrd);
		if(produit.isEmpty()) return null;
		panierUtilisateur.getProduits().add(produit.get());
		panierDao.save(panierUtilisateur);
		return panierToPanierDTO(panierUtilisateur);
	}
	
	
	
	@Override
	public String SupprimerUnProduitDuPanier(Long panId, Long prdId) {
		Optional<Panier> opPan = this.panierDao.findById(panId);
		if (opPan.isPresent()) {
			Produit produitASupprimer = null;
			for (Produit prd : opPan.get().getProduits()) {
				if (prd.getId().equals(prdId)) {
					produitASupprimer = prd;
					break;
				}
			}
			if (produitASupprimer != null) {
				opPan.get().getProduits().remove(produitASupprimer);
				this.panierDao.save(opPan.get());
			}
			return "ok";
		} else {
			return null;
		}
		
	}
	
	
	public PanierDTO panierToPanierDTO(Panier pan) {
		if (pan.getProduits() != null) {
			return PanierDTO.builder()
					.id(pan.getId())
					.produits(pan.getProduits()
							.stream()
							.map(x -> this.produitToProduitDTO(x)).collect(Collectors.toList())).build();
		} else {
			return PanierDTO.builder()
					.id(pan.getId())
					.build();
		}

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
				.id(prd.getId())
				.image(prd.getImage())
				.nom(prd.getNom())
				.prix(prd.getPrix())
				.description(prd.getDescription()).build();
	}



}

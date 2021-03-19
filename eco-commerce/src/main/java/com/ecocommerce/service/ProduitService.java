package com.ecocommerce.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecocommerce.DAO.ProduitDao;
import com.ecocommerce.DTO.ProduitDTO;
import com.ecocommerce.Entity.Produit;
import com.ecocommerce.IService.IProduitService;


@Service
public class ProduitService implements IProduitService{

	@Autowired
	ProduitDao produitDao;
	
	@Override
	public List<ProduitDTO> afficherListeProduit() {
		return this.produitDao.findAll().stream().map(x -> ProduitDTO.builder()
				.id(x.getId())
				.image(x.getImage())
				.nom(x.getNom())
				.prix(x.getPrix())
				.description(x.getDescription()).build())
				.collect(Collectors.toList());
	}
	
	

	@Override
	public ProduitDTO getProduitBuyId(Long id) {
		return this.produitToProduitDTO( this.produitDao.getOne(id));
	}

	@Override
	public String SupprimerProduit(Long id) {
		this.produitDao.deleteById(id);
		return "ok";
	}

	@Override
	public ProduitDTO ajouterProduit(ProduitDTO prd) {
		return this.produitToProduitDTO(this.produitDao.save(this.produitDtoToProduit(prd)));
	}
	
	

	@Override
	public ProduitDTO updateprd(ProduitDTO prd) {
		return this.produitToProduitDTO(this.produitDao.save(this.updateProduitDtoToProduit(prd)));
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
	
	private Produit updateProduitDtoToProduit(ProduitDTO prd){
		return Produit.builder()
				.id(prd.getId())
				.image(prd.getImage())
				.nom(prd.getNom())
				.prix(prd.getPrix())
				.description(prd.getDescription()).build();
	}




}

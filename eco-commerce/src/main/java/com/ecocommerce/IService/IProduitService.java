package com.ecocommerce.IService;

import java.util.List;

import com.ecocommerce.Entity.Produit;

public interface IProduitService {
	
	public List<Produit> afficherListeProduit();
	
	public Produit getProduitBuyId();
	
	public String SupprimerProduit();
	
	public Produit ajouterProduit();

}

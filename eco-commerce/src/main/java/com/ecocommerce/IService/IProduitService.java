package com.ecocommerce.IService;

import java.util.List;

public interface IProduitService {
	
	public List<E> afficherListeProduit();
	
	public Panier getProduitBuyId();
	
	public String SupprimerProduit();
	
	public Panier ajouterProduit();

}

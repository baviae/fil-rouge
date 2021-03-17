package com.ecocommerce.IService;

import java.util.List;

import com.ecocommerce.Entity.Panier;

public interface IPanierService {
	
	public List<Panier> afficherListePanier();
	
	public Panier getpanierBuyId();
	
	public String SupprimerPanier();
	
	public Panier ajouterPanier();

}

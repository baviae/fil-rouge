package com.ecocommerce.IService;

import java.util.List;

public interface IPanierService {
	
	public List<E> afficherListePanier();
	
	public Panier getpanierBuyId();
	
	public String SupprimerPanier();
	
	public Panier ajouterPanier();

}

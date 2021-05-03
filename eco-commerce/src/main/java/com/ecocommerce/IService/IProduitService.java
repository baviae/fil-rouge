package com.ecocommerce.IService;

import java.util.ArrayList;
import java.util.List;

import com.ecocommerce.DTO.ProduitDTO;
import com.ecocommerce.Entity.Produit;

public interface IProduitService {
	
	public List<ProduitDTO> afficherListeProduit();
	
	public ProduitDTO getProduitBuyId(Long id);
	
	public String SupprimerProduit(Long id);
	
	public ProduitDTO ajouterProduit(ProduitDTO prd);
	
	public ProduitDTO updateprd(ProduitDTO prd);

}

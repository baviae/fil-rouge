package com.ecocommerce.IService;

import java.util.List;

import com.ecocommerce.DTO.PanierDTO;

public interface IPanierService {
	
	public List<PanierDTO> afficherListePanier();
	
	public PanierDTO getpanierBuyId(Long id);
	
	public String SupprimerPanier(Long id);
	
	public PanierDTO ajouterPanier(Long id , PanierDTO pan);

}

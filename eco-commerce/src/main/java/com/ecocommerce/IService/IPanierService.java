package com.ecocommerce.IService;

import java.util.List;

import com.ecocommerce.DTO.PanierDTO;
import com.ecocommerce.Entity.Panier;

public interface IPanierService {
	
	public List<PanierDTO> afficherListePanier();
	
	public PanierDTO getpanierByUserId(Long id);
	
	public String SupprimerUnProduitDuPanier(Long panId, Long prdId);
	
	public String SupprimerPanier(Long id);
	
	public PanierDTO ajouterPanier(Long id , Long idPrd);
	
	public PanierDTO panierToPanierDTO(Panier pan);
	
	public Panier panierDTOToPanier(PanierDTO pan);

}

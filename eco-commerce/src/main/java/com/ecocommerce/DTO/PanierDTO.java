package com.ecocommerce.DTO;

import java.util.List;
import com.ecocommerce.Entity.Produit;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class PanierDTO {
	private Long id;
	private List<ProduitDTO> produits;

}

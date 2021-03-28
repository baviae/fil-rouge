package com.ecocommerce.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString

public class ProduitDTO {
	
	private Long id;
	private String nom;
	private String description;
	private String image;
	private Double prix;

}

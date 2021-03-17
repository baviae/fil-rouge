package com.ecocommerce.Entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
@Entity

public class Panier {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "panier_seq")
	private Long id;
	@OneToMany
	private List<Produit> produits;
	

}

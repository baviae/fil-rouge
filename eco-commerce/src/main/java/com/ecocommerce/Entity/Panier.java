package com.ecocommerce.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

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
@Entity
@ToString

public class Panier {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "panier_seq")
	private Long id;
	@ManyToMany
	private List<Produit> produits = new ArrayList<Produit>();
	

}

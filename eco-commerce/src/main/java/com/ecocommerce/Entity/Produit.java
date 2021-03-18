package com.ecocommerce.Entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//classe correspondant à la table produit dans la base de données
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Produit {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "produit_seq")
	private Long id;
	private String nom;
	private String description;
	private String image;
	private Double prix;

}

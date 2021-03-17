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
@Builder
@Entity
public class Produit {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "produit_seq")
	private Long id;
	private String nom;
	private String description;
	private String image;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getImage() {
		return image;
	}
	
	public void setImage(String image) {
		this.image = image;
	}

	public Produit(Long id, String nom, String description, String image) {
		super();
		id = id;
		this.nom = nom;
		this.description = description;
		this.image = image;
	}

}

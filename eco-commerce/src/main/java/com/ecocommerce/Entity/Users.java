package com.ecocommerce.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

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

// C'est la table qui va être crée en base de donnée Grace a l'annotation @Entity
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "user_seq")
    private Long id;
	
	private String nom;
	private String prenom;

    @Column(nullable = false, unique = true)
    private String email;

    private String password;
    
    private String token;
    @OneToOne
    private Panier panier;

}

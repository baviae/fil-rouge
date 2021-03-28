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

// userDto c'est l'objet qui va être utiliser pour envoyer des donner de l'utilisateur vers le front.
public class UserDTO {

	Long id;
	private String nom;
	private String prenom;
    private String email;

    private String password;
    
    private String token;
    private PanierDTO panierDto;
}

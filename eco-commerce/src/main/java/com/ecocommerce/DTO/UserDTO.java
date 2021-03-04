package com.ecocommerce.DTO;

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

// userDto c'est l'objet qui va être utiliser pour envoyer des donner de l'utilisateur vers le front.
public class UserDTO {

    private String username;

    private String password;
    
    private String token;
}

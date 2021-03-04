package com.ecocommerce.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.ecocommerce.DTO.UserDTO;

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
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "user_seq")
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    private String password;
    
    private String token;

}

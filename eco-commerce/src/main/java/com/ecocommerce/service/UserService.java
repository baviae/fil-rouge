package com.ecocommerce.service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ecocommerce.DAO.IPanierDao;
import com.ecocommerce.DAO.UserDao;
import com.ecocommerce.DTO.UserDTO;
import com.ecocommerce.Entity.Panier;
import com.ecocommerce.Entity.Users;
import com.ecocommerce.IService.IPanierService;
import com.ecocommerce.IService.IUserService;

@Service
public class UserService implements IUserService{

	@Autowired
	UserDao userDao;
	
	@Autowired
	IPanierDao panierDao;
	
	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
	IPanierService panierService;
	
	@Override
	public UserDTO saveUser(UserDTO user) {
	
		
		Users users = Users.builder()
				.email(user.getEmail())
				.nom(user.getNom())
				.prenom(user.getPrenom())
				.password(this.encoder.encode(user.getPassword()))
				.panier(this.panierDao.save(new Panier()))
				.build();
		
		Users users2 = this.userDao.save(users);
		
		return UserDTO.builder()
				.email(users2.getEmail())
				.nom(user.getNom())
				.prenom(user.getPrenom())
				.panierDto(this.panierService.panierToPanierDTO(users2.getPanier()))
				.build();
	}

	@Override
	public List<UserDTO> listeUsers() {
		
		return this.userDao.findAll().stream().map(u -> UserDTO.builder().
				email(u.getEmail())
				.nom(u.getNom())
				.prenom(u.getPrenom())
				.panierDto(this.panierService.panierToPanierDTO(u.getPanier()))
				.build()).collect(Collectors.toList());
	}

	@Override
	public UserDTO getUserByHisId(Long id) {
		Optional<Users> us = this.userDao.findById(id);
		
		if (us.isPresent()) {
			return UserDTO.builder()
					.email(us.get().getEmail())
					.nom(us.get().getNom())
					.prenom(us.get().getPrenom())
					.panierDto(this.panierService.panierToPanierDTO(us.get().getPanier()))
					.build();
		} else {
			return null;
		}
		
	}
	
	
	
	
	
	
}

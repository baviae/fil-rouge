package com.ecocommerce.service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ecocommerce.DAO.UserDao;
import com.ecocommerce.DTO.UserDTO;
import com.ecocommerce.Entity.Users;
import com.ecocommerce.IService.IUserService;

@Service
public class UserService implements IUserService{

	@Autowired
	UserDao userDao;
	
	@Autowired
	PasswordEncoder encoder;
	
	@Override
	public UserDTO saveUser(UserDTO user) {
		
		Users users = Users.builder()
				.email(user.getEmail())
				.nom(user.getNom())
				.prenom(user.getPrenom())
				.password(this.encoder.encode(user.getPassword()))
				.build();
		
		Users users2 = this.userDao.save(users);
		
		return UserDTO.builder()
				.email(users2.getEmail())
				.nom(user.getNom())
				.prenom(user.getPrenom())
				.build();
	}

	@Override
	public List<UserDTO> listeUsers() {
		
		return this.userDao.findAll().stream().map(u -> UserDTO.builder().
				email(u.getEmail())
				.nom(u.getNom())
				.prenom(u.getPrenom())
				.build()).collect(Collectors.toList());
	}
	
	

}

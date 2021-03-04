package com.ecocommerce.IService;

import java.util.List;

import com.ecocommerce.DTO.UserDTO;

public interface IUserService {
	
	public UserDTO saveUser(UserDTO user);
	public List<UserDTO> listeUsers();

}

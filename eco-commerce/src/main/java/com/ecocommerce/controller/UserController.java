package com.ecocommerce.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.weaver.PerTypeWithinTargetTypeMunger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ecocommerce.DTO.UserDTO;
import com.ecocommerce.service.UserService;
import com.ecocommerce.utile.JwtGetToken;


@RestController
public class UserController {
	
	@Autowired
	UserService userService;

	@Autowired
	private AuthenticationManager authenticationManager;
		
	
	@PostMapping("/SignIn")
	public UserDTO inscription(@RequestBody UserDTO userDTO) {
		System.out.println("okpppppppp");
		System.out.println(userDTO);
		return this.userService.saveUser(userDTO);
	}
	
	@GetMapping("/login")
	public UserDTO login(@RequestBody UserDTO userDTO) {
		
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
				userDTO.getEmail(), userDTO.getPassword());
		Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

		if (authentication != null && authentication.isAuthenticated()) {
			String token = JwtGetToken.getJWTToken(userDTO.getEmail());
			userDTO.setToken(token);
			userDTO.setPassword(null);
			return userDTO;
		}

		return null;
		
	}
	

	
	@GetMapping("/deconnexion")
	public void controleurDeconnection(HttpServletRequest request,HttpServletResponse res) throws IOException {
		request.getSession().invalidate();
		res.sendRedirect("/login");
	}
	
	@GetMapping("/utilisateurs")
	public List<UserDTO> listeUser(){
		return this.userService.listeUsers();
	}

}

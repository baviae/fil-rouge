package com.ecocommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ecocommerce.DAO.UserDao;
import com.ecocommerce.Entity.Users;
import com.ecocommerce.utile.MyUserPrincipal;

@Service
public class MyUserDetailsService implements UserDetailsService{
	
	@Autowired
    private UserDao userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        Users user = userRepository.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new MyUserPrincipal(user);
    }
}

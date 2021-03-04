package com.ecocommerce.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecocommerce.Entity.Users;

@Repository
public interface UserDao extends JpaRepository<Users, Long>{
	
	 Users findByEmail(String email);
}

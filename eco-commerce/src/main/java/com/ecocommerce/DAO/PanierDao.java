package com.ecocommerce.DAO;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecocommerce.Entity.Panier;

@Repository
public interface PanierDao extends JpaRepository<Panier, Long>{
	Optional<Panier> findById(Long id);

}

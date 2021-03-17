package com.ecocommerce.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecocommerce.Entity.Produit;

@Repository
public interface ProduitDao extends JpaRepository<Produit, Long>{
	
	Optional<Produit> findById(Long id);
	List<Produit> findAll();

}

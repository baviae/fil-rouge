package com.ecocommerce.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecocommerce.Entity.Panier;

public interface IPanierDao extends JpaRepository<Panier, Long>{

}

package com.ecocommerce;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import com.ecocommerce.DAO.ProduitDao;
import com.ecocommerce.DTO.ProduitDTO;
import com.ecocommerce.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class ControllersTests {
	
	
	 @InjectMocks
	  private UserService userService;
	  
    @Autowired
    private WebApplicationContext context;
    
	@Autowired
	private ObjectMapper objectMapper;
	
    @Autowired
    private MockMvc mockMvc;
    
	@Autowired
	ProduitDao produitDao;
     
	
	private static Logger logger = LoggerFactory.getLogger(ControllersTests.class);
	
	
//	TEST PRODUIT ************************************************************************************
	
	@Test
	void ajoutProduit_whenValidInput_thenReturns200() throws Exception {
		ProduitDTO prd = ProduitDTO.builder().nom("prd1").image("image.jpeg").description("description").prix(5.0).build();
	    mockMvc.perform(post("/produit")
	        .contentType("application/json")
	        .content(objectMapper.writeValueAsString(prd)))
	        .andExpect(status().isOk());
	}
	
	
	@Test
	void produisList_whenValidInput_thenReturns200() throws Exception {
	   mockMvc.perform(get("/produits")
			.content("application/json"))
	        .andExpect(status().isOk());
	}
	
	
	@Test
	void getImageProduit_whenValidInput_thenReturns200() throws Exception {
		Long id = this.produitDao.findAll().get(0).getId();
		mockMvc.perform(get("/produits/image/"+ id+"/"+this.produitDao.findAll().get(0).getImage().split("\\.")[1])
			.content("application/json"))
	        .andExpect(status().isOk());
	}
	
// TEST PANIER ***********************************************************************************************
	
	
	
// TEST Utiisateur ***********************************************************************************************
	
	

}

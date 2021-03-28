package com.ecocommerce.configuration;

import java.util.Arrays;
import java.util.Collections;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ecocommerce.service.MyUserDetailsService;
import com.ecocommerce.utile.JWTAuthorizationFilter;



@Configuration
@EnableWebSecurity

public class ConfigurationSpringSecurity extends WebSecurityConfigurerAdapter implements WebMvcConfigurer{
	
	 @Autowired
	 MyUserDetailsService userDetailsService;
	
	   @Autowired
	    public void configure(AuthenticationManagerBuilder auth) 
	      throws Exception {
	        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	    }

	   
	   @Bean
	   public PasswordEncoder passwordEncoder() {
	       return new BCryptPasswordEncoder();
	   }
	   
	   protected void configure(HttpSecurity http) throws Exception {
		   http.csrf().disable()
		   .addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
		   .authorizeRequests()
		   .antMatchers("/SignIn","/login","/connecter","/produits","/produit","/produits/image/{idPrd}/{type}").permitAll()
	          .anyRequest()
	          .authenticated();
		   http.cors();
		}
	   
		@Bean
		@Override
		public AuthenticationManager authenticationManagerBean() throws Exception {
			return super.authenticationManagerBean();
		}

	    @Override
	    public void addCorsMappings(CorsRegistry registry) {
	        registry.addMapping("/**").allowedMethods("*");
	    }

}

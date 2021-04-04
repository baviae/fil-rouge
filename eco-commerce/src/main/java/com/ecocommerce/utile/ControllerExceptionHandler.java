package com.ecocommerce.utile;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	  public void resourceNotFoundException(Exception ex) {
	    System.out.println("exception working !!!");
	   
	  }

}

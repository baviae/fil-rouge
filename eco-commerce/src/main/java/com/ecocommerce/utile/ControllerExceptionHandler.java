package com.ecocommerce.utile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ControllerExceptionHandler {
	
	private static Logger logger = LoggerFactory.getLogger(ControllerExceptionHandler.class);
	
	  @ExceptionHandler(Exception.class)
	  public void resourceNotFoundException(Exception ex) {
			logger.error("[ "+ex.toString()+" ]" +ex.getCause() +" : " + ex.getMessage());
	  }

}

package com.ecocommerce.utile;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;


@ControllerAdvice
public class ControllerExceptionHandler {
	
	private static Logger logger = LoggerFactory.getLogger(ControllerExceptionHandler.class);
	
	  @ExceptionHandler(Exception.class)
	  public ResponseEntity<Object> resourceException(Exception ex, WebRequest request) {
			logger.error("[ "+ex.toString()+" ], cause : => " +ex.getCause() +" : " + ex.getMessage());
			
			if (ex instanceof IOException) {
				return ResponseEntity.badRequest().body(ex.getMessage());
			} else {
				return ResponseEntity.badRequest().body(ex.getMessage());
			}
	  }

}

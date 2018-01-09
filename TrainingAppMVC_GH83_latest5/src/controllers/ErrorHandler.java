package controllers;

import org.springframework.dao.DataAccessException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {
	
	@ExceptionHandler(DataAccessException.class)
	public String databaseExceptionHandler(DataAccessException ex){
		return "errorPage";
	}		
	
	@ExceptionHandler(AccessDeniedException.class)
	public String accessDeniedExceptionHandler(DataAccessException ex){
		return "accessDenied";
	}	
}

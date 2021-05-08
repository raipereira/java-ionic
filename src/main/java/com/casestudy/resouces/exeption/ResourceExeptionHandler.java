package com.casestudy.resouces.exeption;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.casestudy.services.exceptions.DataIntegrityException;
import com.casestudy.services.exceptions.ObjectNotFoundExeption;

@ControllerAdvice
public class ResourceExeptionHandler {
	
	@ExceptionHandler(ObjectNotFoundExeption.class)
	public ResponseEntity<StandardError> objectNotFaund(ObjectNotFoundExeption e, HttpServletRequest request){
		
		StandardError erro = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
		
	}
	
	@ExceptionHandler(DataIntegrityException.class)
	public ResponseEntity<StandardError> DataIntegrityViolation(DataIntegrityException e, HttpServletRequest request){
		
		StandardError erro = new StandardError(HttpStatus.BAD_REQUEST.value(), e.getMessage(), System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
		
	}

	

}

package com.Santero.controllers;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.Santero.entities.ErrorResponse;
import com.Santero.exceptions.CustomDataNotFoundException;
import com.Santero.exceptions.CustomParameterConstraintException;
import com.Santero.exceptions.CustomUnauthorizedException;

@ControllerAdvice
public class ErrorHandlerController {
	
	@ExceptionHandler(CustomDataNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleCustomDataNotFoundExceptions(Exception e){
		
		 HttpStatus status = HttpStatus.NOT_FOUND; // 404
		 
		 StringWriter stringWriter = new StringWriter();
		 PrintWriter printWriter = new PrintWriter(stringWriter);
		 e.printStackTrace(printWriter);
		 String stackTrace = stringWriter.toString();
		 
	     return new ResponseEntity<>(new ErrorResponse(status, e.getMessage(), stackTrace), status);
	     
	}
	
	@ExceptionHandler(CustomParameterConstraintException.class)
	public ResponseEntity<ErrorResponse> handleCustomParameterConstraintExceptions(Exception e){
		
		 HttpStatus status = HttpStatus.BAD_REQUEST; // 400
		 
	     return new ResponseEntity<>(new ErrorResponse(status,e.getMessage()),status);
	     
	}
	
	@ExceptionHandler(CustomUnauthorizedException.class)
	public ResponseEntity<ErrorResponse> handleCustomUnauthorizedException(Exception e){
		
		HttpStatus status = HttpStatus.UNAUTHORIZED; // 401
		StringWriter stringWriter = new StringWriter();
	    PrintWriter printWriter = new PrintWriter(stringWriter);
	    e.printStackTrace(printWriter);
	    String stackTrace = stringWriter.toString();
	    
	    return new ResponseEntity<>(new ErrorResponse(status, e.getMessage(), stackTrace), status);
	    
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleException(Exception e){
		
		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR; // 500
		StringWriter stringWriter = new StringWriter();
	    PrintWriter printWriter = new PrintWriter(stringWriter);
	    e.printStackTrace(printWriter);
	    String stackTrace = stringWriter.toString();
	    
	    return new ResponseEntity<>(new ErrorResponse(status, e.getMessage(), stackTrace), status);
	    
	}
}

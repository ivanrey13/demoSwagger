package com.example.demoSwagger.exceptionhandler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.handler.ResponseStatusExceptionHandler;

//@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseStatusExceptionHandler{

	/*@ExceptionHandler(value= {IllegalArgumentException.class, IllegalStateException.class})
	protected ResponseEntity<Object> handleConflict (RuntimeException ex, WebRequest request){
		String bodyResponse= "esta es una aplicacion especifica";
		return handleExceptionInternal(ex, bodyResponse, new HttpHeaders(), HttpStatus.CONFLICT, request);
	}*/

}

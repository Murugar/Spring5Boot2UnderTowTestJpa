package com.iqmsoft.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class SampleExceptionHandler {
	
	/*
	 * Throw this exception if ToDo with supplied Id is not found in the database
	 */
	@ExceptionHandler(SampleException.class)
	public ResponseEntity<ResponseMessage> notFoundException(Exception ex){
		ResponseMessage rm = new ResponseMessage();
		rm.setMessage(ex.getMessage());
		rm.setErrorCode(HttpStatus.NOT_FOUND.value());
		
		return new ResponseEntity<ResponseMessage>(rm,HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ResponseMessage> exceptionHandler(Exception ex){
		ResponseMessage rm = new ResponseMessage();
		rm.setMessage("Invalid request. Please check your syntax");
		rm.setErrorCode(HttpStatus.BAD_REQUEST.value());
		
		return new ResponseEntity<ResponseMessage>(rm,HttpStatus.BAD_REQUEST);
	}
}

package org.tu_dresden.de.internal.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.fasterxml.jackson.annotation.JsonInclude;



public class ApiExceptionHandler {
	
	@SuppressWarnings("rawtypes")
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity(<ErrorResponse> ResponseEntity handle(ConstraintViolationException e){
		ErrorResponse errors = new ErrorResponse();
		for (ConstraintViolation violation : e.getConstraintViolations()) {
			ErrorItem error = new ErrorItem();
			error.setCode(violation.getMessageTemplate());
			error.setMessage(violation.getMessage());
			((org.tu_dresden.de.internal.exceptions.ApiExceptionHandler.ErrorResponse) errors).addError(error);
		}
		
		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	}
	
	
	// Json include annotation
	public static class ErrorItem {
		@JsonInclude(JsonInclude.Include.NON_NULL) private String code; // Why JSON Include
		
		private String message;
		
		public String getCode() {
			
		}
		
		public void setCode(String code) {
			this.code = code;
		}
		
		public String getMessage() {
			return message;
		}
		
		public void setMessage(String message) {
			this.message = message;
		}
	}
	
	//Do we need this? 
	public class ErrorResponse {
		private List<ErrorItem> errors = new ArrayList<>();
		
		public List<ErrorItem> getErrors() {
			return errors;
		}
		
		public void setErrors(List<ErrorItem> errors) {
			this.errors = errors;
		}
		
		public void addError(ErrorItem error) {
			this.errors.add(error);
		}
	}
}

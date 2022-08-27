package com.verma.contact.controller;

import javax.validation.ValidationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.verma.contact.exception.EmailValidationException;
import com.verma.contact.exception.EmployeeNotfoundException;

@ControllerAdvice
public class EmployeeExceptionController extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(value = EmployeeNotfoundException.class)
	public ResponseEntity<Object> exception(EmployeeNotfoundException exception) {
		return new ResponseEntity<>("Employee Details not found", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = EmailValidationException.class)
	public ResponseEntity<Object> exception(EmailValidationException exception) {
		return new ResponseEntity<>("Invalid Email ID format", HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value=ValidationException.class)
	public ResponseEntity<Object> exception(ValidationException exception) {
		return new ResponseEntity<>("field is empty:"+exception.getMessage(), HttpStatus.BAD_REQUEST);
	}
}

package com.jspiders.hospitalmanagement.exception;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.jspiders.hospitalmanagement.util.ResponseStructure;

@ControllerAdvice
public class ApplicationHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(IdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> idNotFound(IdNotFound ex) {
		ResponseStructure<String> responseStructure = new ResponseStructure<>();
		responseStructure.setMessage(ex.getMessage());
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setData("id not found");
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<ResponseStructure<String>> noSuchElement(NoSuchElementException ex) {
		ResponseStructure<String> responseStructure = new ResponseStructure<>();
		responseStructure.setMessage(ex.getMessage());
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setData("no element found");
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<ObjectError> list = ex.getAllErrors();
		Map<String, String> map = new LinkedHashMap<>();
		for (ObjectError error : list) {
			String fieldName = ((FieldError)error).getField();
			String message = ((FieldError)error).getDefaultMessage();
			
			map.put(fieldName, message);
		}
		return new ResponseEntity<Object>(map,HttpStatus.BAD_REQUEST);
		//this method will solve the error (all the unknown errors) which are coming through bad request implicitly
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ResponseStructure<String>> handleConstraintViolationException(ConstraintViolationException ex){
		ResponseStructure<String> responseStructure = new ResponseStructure<>();
		responseStructure.setMessage(ex.getMessage());
		responseStructure.setStatus(HttpStatus.BAD_REQUEST.value());
		responseStructure.setData("This field should not be null or blank");
		
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.BAD_REQUEST);
	}
}
package com.global.computers.error;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import jakarta.validation.ConstraintViolationException;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<ErrorResponse> handleNoSuchElementException(NoSuchElementException ex) {
		ErrorResponse error = new ErrorResponse(ex.getMessage(), Arrays.asList(ex.getMessage()));
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<Map<String, List<String>>> handleConstraintViolationException(ConstraintViolationException ex) {
		 List<String> errors = ex.getConstraintViolations().stream()
	                .map(t -> t.getMessage())
	                .collect(Collectors.toList());
	        return ResponseEntity.badRequest().body(getErrorMap(errors));	
	}
	
	private Map<String, List<String>> getErrorMap(List<String> error) {
		Map<String, List<String>> errorResponse = new HashMap<>();
		errorResponse.put("errors", error);
		return errorResponse;
	}

}

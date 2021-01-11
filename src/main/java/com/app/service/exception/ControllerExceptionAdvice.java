package com.app.service.exception;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ControllerExceptionAdvice {

	@ExceptionHandler({ NumberFormatException.class, IllegalArgumentException.class})
	@ResponseBody
	public ResponseEntity<Object> handleBadRequest(Exception exp) throws IOException {
		
		return handleExceptionInternal(exp, exp.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	private ResponseEntity<Object> handleExceptionInternal(Exception exp, String expMessage, HttpStatus responseStatus) {

		
		Map<String, Object> response = new HashMap<>();

		response.put("error_details", expMessage);

		return new ResponseEntity<>(response, responseStatus);
	
}
}

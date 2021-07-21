package com.flymanager.api.engins.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class CustomGlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Object> handleEnginNotFoundException(
			ResourceNotFoundException exception,
			WebRequest request) {
		HttpStatus httpStatus = HttpStatus.NOT_FOUND;

		CustomErrorDetails customErrorDetails =
				new CustomErrorDetails(
						new Date(),
						httpStatus.value(),
						httpStatus.getReasonPhrase(),
						exception.getMessage(),
						request.getDescription(false).substring(4));

		return new ResponseEntity<>(customErrorDetails, httpStatus);
	}
}

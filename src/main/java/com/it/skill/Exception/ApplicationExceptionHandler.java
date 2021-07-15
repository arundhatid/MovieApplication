package com.it.skill.Exception;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<ExceptionResponse> handleRecordNotFoundException(RecordNotFoundException exception,
			HttpServletRequest request) {

		ExceptionResponse response = new ExceptionResponse(new Date(System.currentTimeMillis()), exception.getMessage(),
				request.getRequestURL().toString());

		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(MovieNotSavedException.class)
	public ResponseEntity<ExceptionResponse> handleProjectNotSavedException(MovieNotSavedException exception,
			HttpServletRequest request) {

		ExceptionResponse response = new ExceptionResponse(new Date(System.currentTimeMillis()), exception.getMessage(),
				request.getRequestURL().toString());

		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_IMPLEMENTED);

	}

}

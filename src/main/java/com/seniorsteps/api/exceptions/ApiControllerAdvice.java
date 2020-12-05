package com.seniorsteps.api.exceptions;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice("com.seniorsteps.api.controller")
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ApiControllerAdvice {
	
	@ResponseStatus(code=HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler({Exception.class})
	public Error _handleApiException(Exception exception) {
		return new Error("CODE", exception.getMessage());
	}

}

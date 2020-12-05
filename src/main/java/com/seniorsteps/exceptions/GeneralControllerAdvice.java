package com.seniorsteps.exceptions;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice("com.seniorsteps.controller")
@Order(Ordered.LOWEST_PRECEDENCE)
public class GeneralControllerAdvice {

	// General Exception
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler({ Exception.class })
	public ModelAndView handelException(Exception exception) {
		ModelAndView mav = new ModelAndView("errors/500");
		mav.addObject("message", "General Error........");
		return mav;
	}
}

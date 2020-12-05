package com.seniorsteps.exceptions;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice("com.seniorsteps.controller")
@Order(Ordered.HIGHEST_PRECEDENCE)
public class WebControllerAdvice {
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler({NullPointerException.class,ArithmeticException.class})
	public ModelAndView handleNullException(Exception exception) {
		
		ModelAndView mav= new ModelAndView("errors/400");
		mav.addObject("message", exception.getMessage());
		return mav;
		
	}
	
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	@ExceptionHandler({IllegalArgumentException.class})
	public ModelAndView handleIllegalArgumentException(Exception exception) {
		ModelAndView mav = new ModelAndView("errors/400");
		mav.addObject("message", exception.getMessage());
		return mav;
	}

	

}

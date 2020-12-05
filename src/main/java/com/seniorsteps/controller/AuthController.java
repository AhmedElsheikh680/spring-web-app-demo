package com.seniorsteps.controller;

import java.util.Arrays;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.seniorsteps.dao.UserDAO;
import com.seniorsteps.model.User;

@Controller
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	private UserDAO userDao;

	@GetMapping("/login")
	public String login() {
		return "auth/login";
	}

	@PostMapping("/login")
	public ModelAndView processLogin(User user) {
		ModelAndView mav = null;
		User localUser = userDao.findByUsernameAndPassword(user.getUsername(), user.getPassword());
		System.out.println("UserName" + user.getUsername());
		System.out.println("Password" + user.getPassword());
		if (localUser != null) {
			mav = new ModelAndView("hello");
			mav.addObject("user", user.getUsername());
		} else {
			mav = new ModelAndView("auth/login");
			mav.addObject("error", "Invalid Login");
		}
		return mav;

	}
	
	@GetMapping("/signup")
	public ModelAndView signup() {
		ModelAndView mav = new ModelAndView("auth/signup");
		mav.addObject("genders",Arrays.asList("Male","Female"));
		mav.addObject("countries",Arrays.asList("Egypt","Kuwait","Qatar","Turkey"));
		return mav;
		
	}
	
	@PostMapping("/signup")
	public ModelAndView processSignup(@Valid User user, BindingResult result) {
		ModelAndView mav =null;
		if(result.hasErrors()) {
			 mav = new ModelAndView("auth/signup");
			mav.addObject("genders",Arrays.asList("Male","Female"));
			mav.addObject("countries",Arrays.asList("Egypt","Kuwait","Qatar","Turkey"));
			mav.addObject("user",user);
		} else {
			 userDao.save(user);
			mav = new ModelAndView("auth/login");
			
		}
	
		return mav;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

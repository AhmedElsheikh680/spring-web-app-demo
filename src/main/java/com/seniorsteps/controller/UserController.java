package com.seniorsteps.controller;

import java.util.Arrays;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.seniorsteps.dao.UserDAO;
import com.seniorsteps.model.User;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserDAO userDao;
	@GetMapping("/edit/{id}")
	public ModelAndView editUser(@PathVariable("id") int id) {
		User user =  userDao.findById(id).get();
		if(user !=null) {
			ModelAndView mav = new ModelAndView("user/edit-user");
			mav.addObject("genders", Arrays.asList("Male", "Female"));
			mav.addObject("countries", Arrays.asList("Egypt","Kuwait","Qatar","Turkey"));
			mav.addObject("user",user);
			mav.addObject("edit", true);
			return mav;
		}
		return null;
	}
	
	@PostMapping("/edit")
	public ModelAndView processEditUser(@Valid User user, BindingResult result) {
		ModelAndView mav = null;
		System.out.println(result.hasErrors());
		if(true) {
			
			throw new NullPointerException("user.username == null");
//			throw new ArithmeticException();
		}
		if(result.hasErrors()) {
			mav = new ModelAndView("user/edit-user");
			mav.addObject("genders", Arrays.asList("Male", "Female"));
			mav.addObject("countries", Arrays.asList("Egypt","Kuwait","Qatar","Turkey"));
			mav.addObject("user", user);
			mav.addObject("edit", true);
		}else {
			user = userDao.save(user);
			mav = new ModelAndView("hello");

		}
	
			return mav;

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

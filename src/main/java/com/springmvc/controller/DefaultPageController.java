package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.model.User;

import jakarta.servlet.http.HttpSession;

@Controller
public class DefaultPageController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String loadIndexPage() {	
		return "index_page";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loadLoginPage() {
		return "login_page";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String loadRegisterPage() {
		return "register_page";
	}
	
	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public String loadContactPage() {
		return "contact_page";
	}
	
	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public ModelAndView loadProfilePage(HttpSession session) {
		User userSession = (User) session.getAttribute("user");
		ModelAndView mav = new ModelAndView();
		
		if( userSession == null) {
			mav.setViewName("redirect:/");
			return mav;
		}
		
		mav.setViewName("profile_page");
		mav.addObject("user", userSession);
		return mav;
	}
	
}

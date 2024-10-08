package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.model.Owner;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;


@Controller
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String loadIndexPage() {
		return "index";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loadLoginPage() {
		return "login";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView registerController(HttpServletRequest request, HttpSession session) {
		String email = request.getParameter("email");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String username = request.getParameter("username");
		String phone = request.getParameter("phone");
		String password = request.getParameter("password");
		String url = request.getParameter("url");
		
		Owner owner = new Owner(email, phone, firstname, lastname, username, password, url);
		ModelAndView mav = new ModelAndView("login");
		return mav;
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String loadRegisterPage() {
		return "register";
	}
	
}
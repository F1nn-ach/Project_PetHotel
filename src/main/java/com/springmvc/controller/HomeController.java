package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.model.*;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String loadIndexPage() {
		return "index";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String loadRegisterPage() {
		return "register";
	}
	
	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public String loadContactPage() {
		return "contact_us";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView registerController(HttpServletRequest request) {
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email").trim();
		String phone = request.getParameter("phone");
		String password = request.getParameter("password");
		
		HotelManager m = new HotelManager();
		Register regis = new Register(email, phone, firstname, lastname, password);

		boolean result = m.saveRegister(regis);
		if(result) {
			return new ModelAndView("login");
		} else {
			ModelAndView mav = new ModelAndView();
			mav.addObject("err_msg", "ไม่สามารถสมัครสมาชิกได้");
			return mav;
		}
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loadLoginPage() {
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView loginController(HttpServletRequest request, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		HotelManager m = new HotelManager();
		Register user = m.getUserByEmail(email);
		if(password.equals(user.getPassword())) {
			session.setMaxInactiveInterval(5*60);
			session.setAttribute("user", user);
			mav.addObject("user", session.getAttribute("user"));
			mav.setViewName("redirect:/");
			return mav;
		} else {
			mav.addObject("err_msg", "ไม่สามารถเข้าสู๋ระบบได้ กรุณาลองใหม่อีกครั้ง");
			mav.setViewName("login");
			return mav;
		}
	}
}

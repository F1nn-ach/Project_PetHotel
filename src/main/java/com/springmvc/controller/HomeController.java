package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.model.HotelManager;
import com.springmvc.model.Owner;

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
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView registerController(HttpServletRequest request) {
		String email = request.getParameter("email");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String username = request.getParameter("username");
		String phone = request.getParameter("phone");
		String pwd = request.getParameter("password");
		String url = request.getParameter("url");
		
		Owner owner = new Owner(email, phone, firstname, lastname, username, pwd, url);
		HotelManager hm = new HotelManager();
		boolean result = hm.saveOwner(owner);
		if(result) {
			return new ModelAndView("login");
		} else {
			ModelAndView mav = new ModelAndView("register");
			mav.addObject("err_msg", "ไม่สามารถสมัครข้อมูลได้ กรุณาลองใหม่อีกครั้ง");
			return mav;
		}
		
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loadLoginPage() {
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView loginController(HttpServletRequest request, HttpSession session) {
		ModelAndView mav = new ModelAndView("/index");
		
		String email = request.getParameter("email");
		String pwd = request.getParameter("password");
		
		HotelManager hm = new HotelManager();
		Owner owner = hm.getOwnerByEmail(email);
		if(email != null && pwd.equals(owner.getPassword())) {
			session.setMaxInactiveInterval(15 * 60);
			session.setAttribute("owner", owner);
			mav.addObject("owner", session.getAttribute("owner"));
			mav.setViewName("redirect:/index");
			return mav;
		} else {
			mav.addObject("err_msg", "ไม่สามารถเข้าสู่ระบบได้ กรุณาลองใหม่อีกครั้ง");
			return mav;
		}
		
	}
}
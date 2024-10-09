package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.model.HotelManager;
import com.springmvc.model.Register;

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
	public ModelAndView registerController(HttpServletRequest request, HttpSession session) {

		String email = request.getParameter("email");
//		String firstname = request.getParameter("firstname");
//		String lastname = request.getParameter("lastname");
//		String username = request.getParameter("username");
//		String phone = request.getParameter("phone");
//		String password = request.getParameter("password");
//		String url = request.getParameter("url");
		
		HotelManager hm = new HotelManager();
		Register owner = new Register();
		owner.setEmail(email);
		boolean result = hm.saveOwner(owner);
		if(result) {
			return new ModelAndView("login");
		} else {
			ModelAndView mav = new ModelAndView("register");
			mav.addObject("err_msg", "ไม่สามารถสมัครข้อมูลได้ กรุณาลองใหม่อีกครั้ง");
			System.out.println(owner);
			return mav;
		}
		
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loadLoginPage() {
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView loginController() {
		ModelAndView mav = new ModelAndView("/index");
		return mav;
	}
}
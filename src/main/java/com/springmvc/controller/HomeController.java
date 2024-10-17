package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
		try {
			password = PasswordUtil.getInstance().createPassword(password, "mook");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
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
		try {
			password = PasswordUtil.getInstance().createPassword(password, "mook");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		HotelManager m = new HotelManager();
		Register user = m.getUserByEmail(email);
		
		if (user != null && password.equals(user.getPassword())) {
		    session.setMaxInactiveInterval(5 * 60); // 5 minutes
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
	
	@RequestMapping(value = "/yourprofile", method = RequestMethod.GET)
	public ModelAndView loadProfilePage(HttpSession session) {
		ModelAndView mav = new ModelAndView("profile");
		mav.addObject("user", session.getAttribute("user"));
		return mav;
	}
	
	@RequestMapping(value = "/yourprofile", method = RequestMethod.POST)
	public ModelAndView postProfilePage(HttpSession session) {
		ModelAndView mav = new ModelAndView("profile");
		mav.addObject("user", session.getAttribute("user"));
		return mav;
	}
	
	@RequestMapping(value = "/edityourprofile", method = RequestMethod.GET)
	public ModelAndView loadEditProfilePage(HttpSession session) {
		ModelAndView mav = new ModelAndView("editprofile");
		mav.addObject("user", session.getAttribute("user"));
		return mav;
	}
	
	@RequestMapping(value = "/edityourprofile", method = RequestMethod.POST)
	public ModelAndView editProfileController(HttpSession session, HttpServletRequest request) {
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String password = request.getParameter("password");
		try {
			password = PasswordUtil.getInstance().createPassword(password, "mook");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ModelAndView mav = new ModelAndView("editprofile");
		
		HotelManager m = new HotelManager();
		Register user = new Register(email, phone, firstname, lastname, password);
		boolean result = m.updateRegister(user);
		if(result) {
			session.setMaxInactiveInterval(5*60);
			session.setAttribute("user", user);
			mav.addObject("user", session.getAttribute("user"));
			mav.setViewName("redirect:/yourprofile");
			return mav;
		} else {
			mav.addObject("err_msg", "ไม่สามารถแก้ไขข้อมูลได้");
			return mav;
		}
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logoutController(HttpSession session) {
		session.removeAttribute("user");
		return new ModelAndView("index");
	}
}

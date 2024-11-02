package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.manager.*;
import com.springmvc.model.*;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	@RequestMapping(value = "/register_form", method = RequestMethod.POST)
	public ModelAndView getRegister(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		UserManager um = new UserManager();
		User user = new User();
		boolean result;
		
		String email = request.getParameter("user_email");
		String firstname = request.getParameter("user_firstname");
		String lastname = request.getParameter("user_lastname");
		String phone = request.getParameter("user_phone");
		String pwd = request.getParameter("user_password");
		
		try {
			pwd = PasswordUtil.getInstance().createPassword(pwd, "F!nn");
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		
		if (um.isEmailExists(email)) {
			mav.addObject("err_msg", "อีเมลนี้ถูกใช้ไปแล้ว!! กรุณาใช้อีเมลอื่น");
			mav.setViewName("register_page");
			return mav;
		}
		
		user.setUserEmail(email);
		user.setUserFirstname(firstname);
		user.setUserLastname(lastname);
		user.setUserPassword(pwd);
		user.setUserPhone(phone);
		
		result = um.saveOrUpdateUser(user);
		
		if(result) {
			mav.setViewName("redirect:/login");
			System.out.println("Create user success!!");
			return mav;
		}else {
			mav.addObject("err_msg", "ไม่สามารถสมัครสมาชิกได้!! กรุณาลองอีกครั้ง");
			mav.setViewName("register_page");
			System.out.println("Fail to create user!!");
			return mav;
		}
	}
	
	@RequestMapping(value = "/login_form", method = RequestMethod.POST)
	public ModelAndView getLogin(HttpServletRequest request, HttpSession session) {
	    ModelAndView mav = new ModelAndView();
	    UserManager um = new UserManager();
	    String email = request.getParameter("user_email");
	    String pwd = request.getParameter("user_password");

	    User user = um.getLogin(email);

	    if (user == null) {
	        mav.addObject("err_msg", "ไม่พบผู้ใช้ในระบบ กรุณาตรวจสอบอีเมลของคุณ");
	        mav.setViewName("login_page");
	        return mav;
	    }

	    try {
	        pwd = PasswordUtil.getInstance().createPassword(pwd, "F!nn");
	    } catch (Exception ex) {
	        ex.printStackTrace();
	        mav.addObject("err_msg", "เกิดข้อผิดพลาดในระบบ กรุณาลองใหม่อีกครั้ง");
	        mav.setViewName("login_page");
	        return mav;
	    }

	    if (user.getUserPassword().equals(pwd)) {
	        session.setAttribute("user", user);
	        session.setMaxInactiveInterval(15 * 60);
	        mav.addObject("user", session.getAttribute("user"));
	        mav.setViewName("redirect:/"); 
	        
	        System.out.println("Login success for user: " + user.getUserFirstname());
	        return mav;
	    } else {
	        mav.addObject("err_msg", "อีเมล หรือ รหัสผ่านผิด กรุณาลองใหม่อีกครั้ง");
	        mav.setViewName("login_page");
	        
	        System.out.println("Login failed for email: " + email);
	        return mav;
	    }
	}
	
	@RequestMapping(value = "/edityourprofile", method = RequestMethod.GET)
	public ModelAndView loadEditProfilePage(HttpSession session) {
		if(session.getAttribute("user") == null) {
			return new ModelAndView("redirect:/");
		}
		ModelAndView mav = new ModelAndView("editprofile_page");
		mav.addObject("user", session.getAttribute("user"));
		return mav;
	}
	
	@RequestMapping(value = "/edityourprofile", method = RequestMethod.POST)
	public ModelAndView editProfileController(HttpSession session, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		User userSession = (User) session.getAttribute("user");
		UserManager um = new UserManager();
		User user = new User();
		
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		
		user.setUserEmail(email);
		user.setUserFirstname(firstname);
		user.setUserLastname(lastname);
		user.setUserPassword(userSession.getUserPassword());
		user.setUserPhone(phone);

		
		boolean result = um.saveOrUpdateUser(user);
		if(result) {
			session.setMaxInactiveInterval(5*60);
			session.setAttribute("user", user);
			mav.addObject("user", session.getAttribute("user"));
			mav.setViewName("redirect:/profile");
			return mav;
		} else {
			mav.addObject("err_msg", "ไม่สามารถแก้ไขข้อมูลได้");
			mav.setViewName("editprofile_page");
			return mav;
		}
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logoutController(HttpSession session) {
		session.removeAttribute("user");
		return new ModelAndView("redirect:/");
	}
}

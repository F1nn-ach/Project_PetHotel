package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.model.HotelManager;
import com.springmvc.model.Pet;
import com.springmvc.model.Register;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class PetController {
	@RequestMapping(value = "/pet_register", method = RequestMethod.GET)
	public String loadRegisterPetPage() {
		return "petRegister";
	}

	@RequestMapping(value = "/pet_register", method = RequestMethod.POST)
	public ModelAndView petRegisterController(HttpServletRequest request, HttpSession session) {
		String name = request.getParameter("pet_name");
		int ageYear = Integer.parseInt(request.getParameter("pet_ageyear"));
		int ageMonth = Integer.parseInt(request.getParameter("pet_agemonth"));
		String gender = request.getParameter("pet_gender");
		String requests = request.getParameter("pet_request");
		String breed = request.getParameter("breed");
		String detail;
		if (request.getParameter("pet_type").equals("exotic")) {
			detail = request.getParameter("exotic_detail");
		} else {
			detail = request.getParameter("common_detail");
		}
		String type = breed + " " + detail;
		System.out.println(type);

		Register user = (Register) session.getAttribute("user");
		Pet pet = new Pet(name, ageYear, ageMonth, type, gender, requests);
		user.getPets().add(pet);

		ModelAndView mav = new ModelAndView("pet_register");

		HotelManager hm = new HotelManager();
		boolean result = hm.saveRegister(user);
		if (result) {
			mav.addObject("pet", pet);
			mav.setViewName("redirect:/login");
			return mav;
		} else {
			mav.addObject("err_msg", "ไม่สามารถลงทะเบียนสัตว์เลี้ยงได้ กรุณาลองใหม่อีหครั้ง");
			return mav;
		}

	}

	@RequestMapping(value = "/listpets", method = RequestMethod.GET)
	public ModelAndView loadListPetsPetPage(HttpSession session) {
		HotelManager hm = new HotelManager();
		String email = ((Register) session.getAttribute("user")).getEmail();
		Register user = hm.getUserByEmail(email);

		ModelAndView mav = new ModelAndView("listmypet");
		mav.addObject("user", user);
		return mav;
	}
}

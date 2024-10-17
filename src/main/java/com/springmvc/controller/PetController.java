package com.springmvc.controller;

import java.util.*;

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
		String gender = request.getParameter("pet_gender");
		String age = request.getParameter("pet_age");
		String breed = request.getParameter("breed");
		String species = request.getParameter("species");
		
		Register user = (Register) session.getAttribute("user");
		HotelManager hm = new HotelManager();
		Pet pet = new Pet(name, gender, age, breed, species);
		List<Pet> list = hm.getPetByEmail(user.getEmail());
		user.setPets(list);
		user.getPets().add(pet);
		
		boolean result = hm.saveRegister(user);
		if (result) {
			ModelAndView mav = new ModelAndView("redirect:/listpets");
			mav.addObject("pet", list);
			return mav;
		} else {
			ModelAndView mav = new ModelAndView("petRegister");
			mav.addObject("err_msg", "ไม่สามารถลงทะเบียนสัตว์เลี้ยงได้ กรุณาลองใหม่อีกครั้ง");
			return mav;
		}
	}

	@RequestMapping(value = "/listpets", method = RequestMethod.GET)
	public ModelAndView loadListPetsPage(HttpSession session) {
	    HotelManager hm = new HotelManager();
	    String email = ((Register) session.getAttribute("user")).getEmail();
	    List<Pet> list = hm.getPetByEmail(email);

	    ModelAndView mav = new ModelAndView("listmypet");
	    if (list.isEmpty()) {
	        mav.addObject("message", "ไม่มีข้อมูลสัตว์เลี้ยงของคุณ");
	    } else {
	        mav.addObject("pet", list);
	    }
	    return mav;
	}
	
	@RequestMapping(value = "/editmypet", method = RequestMethod.GET)
	public ModelAndView loadEditPetPage(HttpServletRequest request) {
		String id = request.getParameter("id");
		HotelManager hm = new HotelManager();
		Pet pet = hm.getPetById(id);
		
		ModelAndView mav = new ModelAndView("editpet");
		mav.addObject("pet", pet);
		return mav;
	}
	
	@RequestMapping(value = "/editmypet", method = RequestMethod.POST)
	public ModelAndView editPetController(HttpServletRequest request, HttpSession session) {
	    String id = request.getParameter("pet_id");
	    String name = request.getParameter("pet_name");
	    String gender = request.getParameter("pet_gender");
	    String age = request.getParameter("pet_age");
	    String breed = request.getParameter("breed");
	    String species = request.getParameter("species");
	    
	    HotelManager hm = new HotelManager();
	    Pet existingPet = hm.getPetById(id);
	    if (existingPet == null) {
	        ModelAndView mav = new ModelAndView("editpet");
	        mav.addObject("err_msg", "ไม่พบข้อมูลสัตว์เลี้ยงที่ต้องการแก้ไข");
	        return mav;
	    }
	    existingPet.setName(name);
	    existingPet.setGender(gender);
	    existingPet.setAge(age);
	    existingPet.setBreed(breed);
	    existingPet.setSpecies(species);

	    boolean result = hm.updatePet(existingPet);
	    if (result) {
	        ModelAndView mav = new ModelAndView("redirect:/listpets");
	        return mav;
	    } else {
	        ModelAndView mav = new ModelAndView("editpet");
	        mav.addObject("err_msg", "ไม่สามารถแก้ไขข้อมูลสัตว์เลี้ยงได้ กรุณาลองใหม่อีกครั้ง");
	        return mav;
	    }
	}
}

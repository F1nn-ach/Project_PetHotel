package com.springmvc.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.springmvc.manager.PetManager;
import com.springmvc.manager.UserManager;
import com.springmvc.model.*;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class PetController {

    @RequestMapping(value = "/listpets", method = RequestMethod.GET)
    public ModelAndView loadListPetsPage(HttpSession session) {
        ModelAndView mav = new ModelAndView("listpets_page");
        User user = (User) session.getAttribute("user");
        
        if (user == null) {
            return new ModelAndView("redirect:/logout");
        }
        
        PetManager pm = new PetManager();
        List<Pet> pets = pm.getPetByEmail(user.getUserEmail());
        
        if (pets.isEmpty()) {
            mav.addObject("err_msg", "ไม่มีข้อมูลสัตว์เลี้ยงของคุณ");
        } else {
            mav.addObject("pets", pets);
        }
        return mav;
    }
    
    @RequestMapping(value = "/pet_register", method = RequestMethod.GET)
    public ModelAndView loadRegisterPetPage(HttpSession session) {
        ModelAndView mav = new ModelAndView("registerpet_page");
        
        if (session.getAttribute("user") == null) {
            return new ModelAndView("redirect:/logout");
        }
        
        PetManager pm = new PetManager();
        List<PetType> petTypes = pm.getPetTypes();
        
        mav.addObject("petTypes", petTypes);
        
        return mav;
    }
	
    @RequestMapping(value = "/pet_register", method = RequestMethod.POST)
    public ModelAndView petRegisterController(HttpServletRequest request, HttpSession session) {
        ModelAndView mav = new ModelAndView("registerpet_page");

        User user = (User) session.getAttribute("user");
        if (user == null) {
            return new ModelAndView("redirect:/logout");
        }

        String name = request.getParameter("pet_name");
        String gender = request.getParameter("pet_gender");
        String age = request.getParameter("pet_age");
        String petTypeName = request.getParameter("pet_type");
        String breedName = request.getParameter("breed"); 
        String customBreed = request.getParameter("custom_breed"); 

        PetManager pm = new PetManager();
        UserManager um = new UserManager();

        PetType petType = pm.getPetTypeByName(petTypeName);
        String breed;

        if ("อื่นๆ".equals(breedName) && customBreed != null && !customBreed.isEmpty()) {
            breed = customBreed; 
        } else {
            breed = breedName; 
        }

        if (petType == null || breed == null) {
            mav.addObject("err_msg", "ข้อมูลประเภทหรือสายพันธุ์สัตว์เลี้ยงไม่ถูกต้อง");
            return mav;
        }

        Pet pet = new Pet();
        pet.setPetId();
        pet.setPetName(name);
        pet.setPetGender(gender);
        pet.setPetAge(age);
        pet.setPetType(petType);
        pet.setPetBreed(breed);
        pet.setUser(user);

        List<Pet> petList = pm.getPetByEmail(user.getUserEmail());
        user.setUserPets(petList);
        user.getUserPets().add(pet);

        boolean result = um.saveOrUpdateUser(user); 
        if (result) {
            return new ModelAndView("redirect:/listpets");
        } else {
            mav.addObject("err_msg", "ไม่สามารถลงทะเบียนสัตว์เลี้ยงได้ กรุณาลองใหม่อีกครั้ง");
            return mav;
        }
    }
    
    @RequestMapping(value = "/editmypet", method = RequestMethod.GET)
	public ModelAndView loadEditPetPage(HttpServletRequest request, HttpSession session) {
		if(session.getAttribute("user") == null) {
			return new ModelAndView("redirect:/logout");
		}
		
		String id = request.getParameter("id");
		ModelAndView mav = new ModelAndView("editpet_page");
        PetManager pm = new PetManager();
        Pet pet = pm.getPetById(id);
        List<PetType> petTypes = pm.getPetTypes(); 
        
        mav.addObject("pet", pet);
        mav.addObject("petTypes", petTypes);
        return mav;
	}
	
    @RequestMapping(value = "/updatepet", method = RequestMethod.POST)
    public ModelAndView updatePetController(HttpServletRequest request, HttpSession session) {
        ModelAndView mav = new ModelAndView("editpet_page");
        
        if (session.getAttribute("user") == null) {
            return new ModelAndView("redirect:/logout");
        }

        String petId = request.getParameter("petId");
        String name = request.getParameter("pet_name");
        String gender = request.getParameter("pet_gender");
        String age = request.getParameter("pet_age");
        String petTypeName = request.getParameter("pet_type");
        String breedName = request.getParameter("breed");
        String customBreed = request.getParameter("custom_breed");

        PetManager pm = new PetManager();
        
        Pet existingPet = pm.getPetById(petId);
        if (existingPet == null) {
            mav.addObject("err_msg", "ไม่พบข้อมูลสัตว์เลี้ยงที่ต้องการแก้ไข");
            return mav;
        }

        PetType petType = pm.getPetTypeByName(petTypeName);
        if (petType == null) {
            mav.addObject("err_msg", "ประเภทสัตว์เลี้ยงไม่ถูกต้อง");
            return mav;
        }

        String finalBreed = "อื่นๆ".equals(breedName) && customBreed != null && !customBreed.isEmpty() 
            ? customBreed 
            : breedName;

        existingPet.setPetName(name);
        existingPet.setPetGender(gender);
        existingPet.setPetAge(age);
        existingPet.setPetType(petType);
        existingPet.setPetBreed(finalBreed);

        boolean result = pm.updatePet(existingPet);
        if (result) {
            return new ModelAndView("redirect:/listpets");
        } else {
            mav.addObject("err_msg", "ไม่สามารถแก้ไขข้อมูลสัตว์เลี้ยงได้ กรุณาลองใหม่อีกครั้ง");
            List<PetType> petTypes = pm.getPetTypes();
            mav.addObject("petTypes", petTypes);
            mav.addObject("pet", existingPet);
            return mav;
        }
    }

    @RequestMapping(value = "/deletepet", method = RequestMethod.GET)
    public ModelAndView deletePetController(HttpServletRequest request, HttpSession session) {
        ModelAndView mav = new ModelAndView("redirect:/listpets");
        
        if (session.getAttribute("user") == null) {
        	mav.setViewName("redirect:/logout");
            return mav;
        }

        String petId = request.getParameter("id");
        if (petId == null || petId.trim().isEmpty()) {
            mav.addObject("err_msg", "ไม่พบรหัสสัตว์เลี้ยงที่ต้องการลบ");
            return mav;
        }

        PetManager pm = new PetManager();
        Pet pet = pm.getPetById(petId);
        
        if (pet == null) {
            mav.addObject("err_msg", "ไม่พบข้อมูลสัตว์เลี้ยงที่ต้องการลบ");
            return mav;
        }

        User user = (User) session.getAttribute("user");
        
        List<Pet> userPets = pm.getPetByEmail(user.getUserEmail());
        boolean isPetOwner = userPets.stream()
            .anyMatch(p -> p.getPetId().equals(petId));
            
        if (!isPetOwner) {
            mav.addObject("err_msg", "คุณไม่มีสิทธิ์ลบข้อมูลสัตว์เลี้ยงนี้");
            return mav;
        }

        boolean result = pm.deletePet(pet);
        if (!result) {
            mav.addObject("err_msg", "ไม่สามารถลบข้อมูลได้ กรุณาลองใหม่อีกครั้ง");
        }
        
        return mav;
    }
	 
}

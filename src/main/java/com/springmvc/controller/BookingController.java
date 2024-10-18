package com.springmvc.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.model.Booking;
import com.springmvc.model.HotelManager;
import com.springmvc.model.Pet;
import com.springmvc.model.Register;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class BookingController {
	@RequestMapping(value = "/booking", method = RequestMethod.GET)
    public ModelAndView loadBookingPage(HttpSession session) {
		if(session.getAttribute("user") == null) {
			return new ModelAndView("redirect:/");
		}
		
        HotelManager hm = new HotelManager();
        String email = ((Register) session.getAttribute("user")).getEmail();
        List<Pet> list = hm.getPetByEmail(email);

        ModelAndView mav = new ModelAndView("booking");
        if (list == null || list.isEmpty()) {
            mav.addObject("err_msg", "ไม่มีข้อมูลสัตว์เลี้ยงของคุณ");
        } else {
            mav.addObject("petList", list);
        }
        return mav;
    }
	
	@RequestMapping(value = "/booking", method = RequestMethod.POST)
    public ModelAndView bookingController(HttpServletRequest request, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		
		HotelManager hm = new HotelManager(); 
		String email = ((Register) session.getAttribute("user")).getEmail();
		List<Pet> listpet = hm.getPetByEmail(email);
		
	    String petId = request.getParameter("pet");
	    String startDate = request.getParameter("startDate");
	    String startTime = request.getParameter("startTime");
	    String endDate = request.getParameter("endDate");
	    String endTime = request.getParameter("endTime");
	    String requests = request.getParameter("requests");
	    
	    Calendar startCalendar = Calendar.getInstance();
	    try {
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	        String startDateTime = startDate + " " + startTime;
	        startCalendar.setTime(sdf.parse(startDateTime));
	    } catch (ParseException e) {
	        e.printStackTrace(); 
	    }
	    
	    Calendar endCalendar = Calendar.getInstance();
	    try {
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	        String endDateTime = endDate + " " + endTime;
	        endCalendar.setTime(sdf.parse(endDateTime));
	    } catch (ParseException e) {
	        e.printStackTrace();
	    }
	    
	    Pet pet = hm.getPetById(petId);
	    List<Booking> list = hm.getBookingByPetid(petId);
	    
	    for (Booking b : list) {
	        if (b.isOverlapping(startCalendar, endCalendar, b.getStartDate(), b.getEndDate())) {
	        	mav.addObject("err_msg", "คุณได้ทำการจองในช่วงเวลานี้ไปแล้ว กรุณาเลือกช่วงเวลาอื่น");
	        	mav.addObject("petList", listpet);
	            mav.setViewName("booking"); 
	            return mav;
	        }
	    }
	    
	    Booking booking = new Booking(startCalendar, endCalendar, requests);
	    pet.setBookings(list);
	    pet.getBookings().add(booking);
    
	    boolean result = hm.savePet(pet);
	    if(result) {
	    	session.setAttribute("booking", booking);
	    	session.setAttribute("pet", pet);
	    	mav.setViewName("redirect:/yourbooking");
	    	return mav;
	    } else {
	    	mav.addObject("err_msg", "ไม่สามารถทำาการจองได้ กรุณาลองใหม่อีกครั้ง");
	    	mav.addObject("petList", listpet);
	    	mav.setViewName("booking");
	    	return mav;
	    }
    }
	
	@RequestMapping(value = "/yourbooking", method = RequestMethod.GET)
    public ModelAndView loadYourBookingPage(HttpSession session) {
		if(session.getAttribute("user") == null) {
			return new ModelAndView("redirect:/");
		}
		ModelAndView mav = new ModelAndView("yourbooking");
		mav.addObject("user", session.getAttribute("user"));
		mav.addObject("pet", session.getAttribute("pet"));
		mav.addObject("booking", session.getAttribute("booking"));
		return mav;
    }
	
	@RequestMapping(value = "/backtohome", method = RequestMethod.GET)
    public ModelAndView removeSessionLink(HttpSession session) {
		if(session.getAttribute("user") == null) {
			return new ModelAndView("redirect:/");
		}
		session.removeAttribute("pet");
		session.removeAttribute("booking");
		return new ModelAndView("index");
    }

}

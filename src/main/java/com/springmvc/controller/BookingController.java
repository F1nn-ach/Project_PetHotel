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
        HotelManager hm = new HotelManager();
        String email = ((Register) session.getAttribute("user")).getEmail();
        List<Pet> list = hm.getPetByEmail(email);

        ModelAndView mav = new ModelAndView("booking");
        if (list == null || list.isEmpty()) {
            mav.addObject("message", "ไม่มีข้อมูลสัตว์เลี้ยงของคุณ");
        } else {
            mav.addObject("petList", list);
        }
        return mav;
    }
	
	@RequestMapping(value = "/booking", method = RequestMethod.POST)
    public ModelAndView bookingController(HttpServletRequest request, HttpSession session) {
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
	    
	    Register user = (Register) session.getAttribute("user");
	    HotelManager hm = new HotelManager();
	    Pet pet = hm.getPetById(petId);
	    
	    Booking b = new Booking();
	    b.setStartDate(startCalendar);
	    b.setEndDate(endCalendar);
	    b.setRequest(requests);
	    b.setPet(pet);

	    List<Booking> list = hm.getBookingByEmail(user.getEmail());
	    System.out.println(list.toString());
	    user.setBookings(list);
	    user.getBookings().add(b);
	    pet.setBookings(list);
	    pet.getBookings().add(b);
    
	    boolean result = hm.saveRegister(user);
	    if(result) {
	    	ModelAndView mav = new ModelAndView("redirect:/listbooking");
	    	mav.addObject("b", list);
	    	return mav;
	    } else {
	    	ModelAndView mav = new ModelAndView("booking");
	    	mav.addObject("err_msg", "ไม่สามารถทำาการจองได้ กรุณาลองใหม่อีกครั้ง");
	    	return mav;
	    }
    }

}

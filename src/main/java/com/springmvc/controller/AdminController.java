package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.manager.*;
import com.springmvc.model.*;

import jakarta.servlet.http.HttpSession;

import java.util.*;

@Controller
public class AdminController {

	@RequestMapping(value = "/adminDashboard", method = RequestMethod.GET)
	public ModelAndView loadDashboardPage(HttpSession session) {
		ModelAndView mav = new ModelAndView();

		UserManager um = new UserManager();
		BookingManager bm = new BookingManager();
		PetManager pm = new PetManager();

		User currentUser = (User) session.getAttribute("user");
		if (currentUser == null || !currentUser.isAdmin()) {
			mav.setViewName("redirect:/logout");
			return mav;
		}

		try {
			// User and pets mapping (unchanged)
			List<User> users = um.getAllUsers();
			Map<User, List<Pet>> userPetsMap = new HashMap<>();
			for (User user : users) {
				List<Pet> userPets = pm.getPetsByUser(user.getUserEmail());
				userPetsMap.put(user, userPets);
			}

			// Group bookings by status
			List<Booking> allBookings = bm.getAllBookings();
			Map<String, List<Booking>> bookingsByStatus = new HashMap<>();

			for (Booking booking : allBookings) {
				String status = booking.getStatus().getStatusName();
				bookingsByStatus.computeIfAbsent(status, k -> new ArrayList<>()).add(booking);
			}

			mav.addObject("userPetsMap", userPetsMap);
			mav.addObject("bookingsByStatus", bookingsByStatus);
			mav.addObject("admin", currentUser);

			mav.setViewName("admin_dashboard_page");
		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("error", "An error occurred while loading the dashboard");
			mav.setViewName("error_page");
		}

		return mav;
	}
	  
	  

}
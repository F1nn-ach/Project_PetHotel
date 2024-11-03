package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.manager.*;
import com.springmvc.model.*;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
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
			List<User> users = um.getAllUsers();
			Map<User, List<Pet>> userPetsMap = new HashMap<>();
			for (User user : users) {
				List<Pet> userPets = pm.getPetsByUser(user.getUserEmail());
				userPetsMap.put(user, userPets);
			}

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
	  
	@RequestMapping(value = "/editBooking", method = RequestMethod.GET)
	public ModelAndView loadEditBooking(HttpServletRequest request, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		
		User currentUser = (User) session.getAttribute("user");
		if (currentUser == null || !currentUser.isAdmin()) {
			mav.setViewName("redirect:/logout");
			return mav;
		}
		
		BookingManager bm = new BookingManager();
		
		String bookingId = request.getParameter("id");
		Booking booking = bm.getBookingById(bookingId);
		
		mav.addObject("booking", booking);
		mav.setViewName("editBooking_page");
		return mav;
	}
	
	@RequestMapping(value = "/updateStatus", method = RequestMethod.POST)
	public String updateBookingStatus(HttpServletRequest request) {
	    String bookingId = request.getParameter("bookingId");
	    int statusId = Integer.parseInt(request.getParameter("status"));
	    
	    BookingManager bookingManager = new BookingManager();
	    boolean updated = bookingManager.updateBookingStatus(bookingId, statusId);
	    
	    if (updated) {
	        return "redirect:/editBooking?id=" + bookingId + "&success=true";
	    } else {
	        return "redirect:/editBooking?id=" + bookingId + "&error=true";
	    }
	}

	public static final String saveimage = "D:\\F1nn\\WEB_A.SAYAN2\\Project_PetHotel\\src\\main\\webapp\\assets\\img";

	@RequestMapping(value = "/updateActivity", method = RequestMethod.POST)
	public String updateActivity(HttpServletRequest request, @RequestParam("activityImg") MultipartFile activityImg) {
	    try {
	        String fileName = System.currentTimeMillis() + "_" + activityImg.getOriginalFilename();
	        Path imgPath = Paths.get(saveimage, fileName);
	        
	        if (activityImg != null && !activityImg.isEmpty()) {
	            byte[] imgBytes = activityImg.getBytes();
	            Files.write(imgPath, imgBytes);
	            System.out.println("File saved: " + fileName);
	        }
	        
	        String activityDetail = request.getParameter("activityDetail");
	        LocalDate activityDate = LocalDate.parse(request.getParameter("activityDate"));
	        String petId = request.getParameter("petId");
	        String bookingId = request.getParameter("bookingId");
	        
	        ActivityManager activityManager = new ActivityManager();
	        boolean created = activityManager.createActivity(
	            activityDetail, 
	            fileName, 
	            activityDate,
	            petId,
	            bookingId
	        );
	        
	        if (created) {
	            return "redirect:/editBooking?id=" + bookingId + "&success=true";
	        }
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    
	    return "redirect:/editBooking?id=" + request.getParameter("bookingId") + "&error=true";
	}
}
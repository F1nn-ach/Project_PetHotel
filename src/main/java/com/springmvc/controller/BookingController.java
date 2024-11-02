package com.springmvc.controller;

import com.springmvc.model.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import com.springmvc.manager.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Controller
public class BookingController {
    @RequestMapping(value = "/listbookings", method = RequestMethod.GET)
    public ModelAndView loadListBookingPage(HttpSession session) {
        ModelAndView mav = new ModelAndView();
        User user = (User) session.getAttribute("user");

        if (user == null) {
            mav.setViewName("redirect:/logout");
            return mav;
        }

        BookingManager bookingManager = new BookingManager();
        List<Booking> bookings = bookingManager.getBookingByUserPetEmail(user.getUserEmail());

        if (bookings.isEmpty()) {
            mav.addObject("err_msg", "ไม่มีข้อมูลการจองของคุณ");
            System.out.println("No bookings found for user: " + user.getUserEmail());
        } else {
            mav.addObject("bookings", bookings);
            System.out.println("Bookings retrieved for user: " + user.getUserEmail() + " - " + bookings.size() + " found.");
        }

        mav.setViewName("listbookings_page");
        return mav;
    }

    @RequestMapping(value = "/booking", method = RequestMethod.GET)
    public ModelAndView loadBookingPage(HttpSession session) {
        ModelAndView mav = new ModelAndView("booking_page");
        User user = (User) session.getAttribute("user");

        if (user == null) {
            return new ModelAndView("redirect:/logout");
        }

        PetManager pm = new PetManager();
        BookingManager bm = new BookingManager();

        List<Pet> userPets = pm.getPetByEmail(user.getUserEmail());
        List<Pet> availablePets = new ArrayList<>();
        
        if (userPets.isEmpty()) {
            ModelAndView redirectMav = new ModelAndView("redirect:/pets");
            redirectMav.addObject("err_msg", "กรุณาเพิ่มข้อมูลสัตว์เลี้ยงก่อนทำการจอง");
            return redirectMav;
        }

        List<RoomType> roomTypes = bm.getAllRoomType();

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String today = dateFormat.format(cal.getTime());
        
        for (Pet pet : userPets) {
            if (!bm.isPetBooked(pet.getPetId())) {
                availablePets.add(pet);
            }
        }

        mav.addObject("petList", availablePets);
        mav.addObject("roomTypes", roomTypes);
        mav.addObject("today", today);

        return mav;
    }

    @RequestMapping(value = "/booking", method = RequestMethod.POST)
    public ModelAndView processBooking(HttpServletRequest request, HttpSession session) {
        ModelAndView mav = new ModelAndView();

        try {
            User user = (User) session.getAttribute("user");
            if (user == null) {
                mav.setViewName("redirect:/logout");
                return mav;
            }

            BookingManager bm = new BookingManager();
            PetManager pm = new PetManager();

            String petId = request.getParameter("pet");
            int roomTypeId = Integer.parseInt(request.getParameter("roomTypeId"));
            String startDate = request.getParameter("startDate");
            String startTime = request.getParameter("startTime");
            String endDate = request.getParameter("endDate");
            String endTime = request.getParameter("endTime");
            String requests = request.getParameter("requests");

            Pet pet = pm.getPetById(petId);
            if (pet == null || !pet.getUser().getUserEmail().equals(user.getUserEmail())) {
                mav.addObject("err_msg", "ไม่พบข้อมูลสัตว์เลี้ยงที่เลือก");
                mav.setViewName("booking_page");
                return mav;
            }

            DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            LocalDateTime startDateTime = LocalDateTime.parse(startDate + " " + startTime, dateTimeFormat);
            LocalDateTime endDateTime = LocalDateTime.parse(endDate + " " + endTime, dateTimeFormat);

            Calendar startCalendar = Calendar.getInstance();
            startCalendar.setTime(Date.from(startDateTime.atZone(ZoneId.systemDefault()).toInstant()));

            Calendar endCalendar = Calendar.getInstance();
            endCalendar.setTime(Date.from(endDateTime.atZone(ZoneId.systemDefault()).toInstant()));

            if (startCalendar.after(endCalendar)) {
                mav.addObject("err_msg", "วันที่จองไม่ถูกต้อง");
                mav.setViewName("booking_page");
                return mav;
            }

            RoomType roomType = bm.getRoomTypeById(roomTypeId);
            if (roomType == null) {
                mav.addObject("err_msg", "ไม่พบประเภทห้องที่เลือก");
                mav.setViewName("booking_page");
                return mav;
            }

            List<Room> availableRooms = bm.findAvailableRoom(roomType.getRoomTypeId(), startCalendar, endCalendar);
            if (availableRooms == null || availableRooms.isEmpty()) {
                mav.addObject("err_msg", "ไม่มีห้องว่างในช่วงเวลาที่เลือก กรุณาเลือกช่วงเวลาอื่น");
                mav.setViewName("booking_page");
                return mav;
            }

            Room availableRoom = availableRooms.get(0);
            bm.updateRoomStatus(availableRoom.getRoomId(), false);

            BookingStatus status = bm.getStatusById("1");
            Booking booking = new Booking();
            booking.setBookingId(); 
            booking.setStartDate(startCalendar);
            booking.setEndDate(endCalendar);
            booking.setRequest(requests != null ? requests : "");
            booking.setStatus(status);
            booking.setRoom(availableRoom);
            booking.setPet(pet);

            double duration = booking.calculateDurationInDaysAndHours(startCalendar, endCalendar);
            double totalPrice = (availableRoom.getRoomType().getRoomTypePrice() * duration) + pet.getPetType().getPetCarePrice();
            System.out.println(totalPrice);

            if (!bm.createBooking(booking)) {
                bm.updateRoomStatus(availableRoom.getRoomId(), true);
                mav.addObject("err_msg", "เกิดข้อผิดพลาดในการจอง กรุณาลองใหม่อีกครั้ง");
                mav.setViewName("booking_page");
                return mav;
            }

            BookingHistory bookingHistory = new BookingHistory();
            bookingHistory.setCreatedAt(Calendar.getInstance());
            bookingHistory.setBooking(booking);
            bookingHistory.setUser(user);
            bm.addBookingHistory(bookingHistory);

            mav.addObject("success_msg", "จองห้องพักสำเร็จ รหัสการจอง: " + booking.getBookingId());
            mav.setViewName("redirect:/listbookings");

        } catch (Exception e) {
            mav.addObject("err_msg", "เกิดข้อผิดพลาดที่ไม่ทราบสาเหตุ กรุณาลองใหม่อีกครั้ง: " + e.getMessage());
            mav.setViewName("booking_page");
        }
        return mav;
    }
    
    @RequestMapping(value = "/getBooking", method = RequestMethod.GET)
    public ModelAndView getBooking(HttpServletRequest request, HttpSession session) {
        ModelAndView mav = new ModelAndView();
        String bookingId = request.getParameter("id");
        
        BookingManager bm = new BookingManager();
        Booking booking = bm.getBookingById(bookingId);
        
        if (booking == null) {
            mav.addObject("message", "ไม่พบการจองที่คุณระบุ");
            mav.setViewName("error_page"); 
            return mav;
        }
        
        List<PetActivity> petActivity = bm.getPetActivityByBookingId(bookingId);
        
        if (petActivity == null || petActivity.isEmpty()) {
            mav.addObject("message", "ไม่มีกิจกรรมของสัตว์เลี้ยงคุณในตอนนี้");
        }
        
        mav.addObject("activity", petActivity);
        mav.addObject("booking", booking);
        mav.setViewName("bookingdetail_page");
        
        return mav;
    }

    
}
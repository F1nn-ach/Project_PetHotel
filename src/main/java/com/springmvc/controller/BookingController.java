package com.springmvc.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.model.HotelManager;
import com.springmvc.model.Pet;
import com.springmvc.model.Register;

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

}

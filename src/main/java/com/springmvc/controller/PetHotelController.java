package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class PetHotelController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String loadIndexPage() {
		return "index";
	}

}
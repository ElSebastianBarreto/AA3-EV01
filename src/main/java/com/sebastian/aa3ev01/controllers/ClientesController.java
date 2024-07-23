package com.sebastian.aa3ev01.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClientesController {
	
	@GetMapping({"", "/"})
	public String home() {
		
		
		return "index";

	}

	
	@GetMapping("/contact")
	public String contact() {
		
		
		return "contact";

	}
	

	

}
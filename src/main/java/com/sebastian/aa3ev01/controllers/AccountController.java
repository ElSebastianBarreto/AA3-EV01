package com.sebastian.aa3ev01.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sebastian.aa3ev01.models.RegistroDto;
import com.sebastian.aa3ev01.repositories.ClientesRepository;



@Controller
public class AccountController {

@Autowired ClientesRepository repo;
	@GetMapping("/register")
	public String register(Model model) {
	    RegistroDto registerDto = new RegistroDto();
	    model.addAttribute("registerDto", registerDto);
	    model.addAttribute("success", false);
	    return "register";
	}
}
package com.sebastian.aa3ev01.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sebastian.aa3ev01.models.Cliente;
import com.sebastian.aa3ev01.repositories.*;

@Controller
public class HomeController {
	@Autowired
	private ClientesRepository repo;
	@GetMapping({"", "/"})
public String showClientList(Model model) {
		
		
		List<Cliente> clientes = repo.findAll();
		model.addAttribute("cliente", clientes);
		return "index";
	}


	
	   @GetMapping("/login")
	    public String login() {
	        return "login"; // Nombre de la plantilla Thymeleaf
	    }

	

}
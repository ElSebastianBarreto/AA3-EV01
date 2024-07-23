package com.sebastian.aa3ev01.controllers;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sebastian.aa3ev01.models.Cliente;
import com.sebastian.aa3ev01.models.ClienteDto;
import com.sebastian.aa3ev01.repositories.ClienteRepo;
import com.sebastian.aa3ev01.repositories.ClientesRepository;

import jakarta.validation.Valid;
@Controller
public class EditDeleteCliente {

	@Autowired ClienteRepo repo;
	
	@GetMapping("/edit")
	public String showEditPage(Model model, @RequestParam int cedula) {
	
	try {
		Cliente cliente = repo.findById(cedula).get();
		model.addAttribute("cliente", cliente);
		
		ClienteDto clienteDto = new ClienteDto();
		clienteDto.setCedula(cliente.getCedula());
		clienteDto.setNombre(cliente.getNombre());
		clienteDto.setApellido(cliente.getApellido());
		clienteDto.setEdad(cliente.getEdad());
		clienteDto.setCorreo(cliente.getCorreo());
		clienteDto.setClave(cliente.getClave());
		clienteDto.setTelefono(cliente.getTelefono());
		
		model.addAttribute("clienteDto", clienteDto);
		
		
		
	}
	
	catch(Exception ex){
		
		System.out.println("Exception: "+ex.getMessage());
		
		return "redirect:/";
	}
	
	
	return "edit";
	
	
	}
	
	
	
	@PostMapping("/edit")
	public String updateCliente(
			Model model,
			@RequestParam int cedula,
			@Valid @ModelAttribute ClienteDto clienteDto,
			BindingResult result
			
			) {
		
		try {
			
			Cliente cliente = repo.findById(cedula).get();
			model.addAttribute("cliente", cliente);
			
			if(result.hasErrors()) {
				
				return "edit";
			}
			
			
		
		
			
			
			cliente.setCedula(clienteDto.getCedula());

			cliente.setNombre(clienteDto.getNombre());

			cliente.setApellido(clienteDto.getApellido());
			cliente.setEdad(clienteDto.getEdad());
			cliente.setCorreo(clienteDto.getCorreo());
			cliente.setClave(clienteDto.getClave());
			cliente.setTelefono(clienteDto.getTelefono());

			repo.save(cliente);
			
			
			
		}catch(Exception ex){
			
			System.out.println("Exception: "+ex.getMessage());
			
			
		}
		return "redirect:/";
	}
	
	
	
}

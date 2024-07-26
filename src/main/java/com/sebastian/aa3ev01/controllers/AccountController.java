package com.sebastian.aa3ev01.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sebastian.aa3ev01.models.Cliente;
import com.sebastian.aa3ev01.models.RegistroDto;
import com.sebastian.aa3ev01.repositories.ClientesRepository;

import jakarta.validation.Valid;

@Controller
public class AccountController {

    @Autowired
    ClientesRepository repo;

    @GetMapping("/register")
    public String register(Model model) {

        model.addAttribute("registerDto", new RegistroDto());
        model.addAttribute("success", false);
        return "register";
    }

    @PostMapping("/register")
    public String register(Model model,
                           @Valid @ModelAttribute("registerDto") RegistroDto registerDto,
                           BindingResult result) {
        // Se inicializa en false
    	if (result.hasErrors()) {
            return "register";
        }
    	
        if (!registerDto.getClave().equals(registerDto.getConfirmClave())) {
            result.addError(new FieldError("registerDto", "confirmClave", "Las contraseñas no coinciden"));
        }

        Cliente appUser = repo.findByCedula(registerDto.getCedula());
        if (appUser != null) {
            result.addError(new FieldError("registerDto", "cedula", "ya tienes cuenta inicia sesion"));
        }

        if (result.hasErrors()) {
        	model.addAttribute("success", false);
            return "register"; 
        }

        try {
            var bCryptEncoder = new BCryptPasswordEncoder();
            Cliente newUser = new Cliente();
            newUser.setCedula(registerDto.getCedula());
            newUser.setNombre(registerDto.getNombre());
            newUser.setApellido(registerDto.getApellido());
            newUser.setEdad(registerDto.getEdad());
            newUser.setCorreo(registerDto.getCorreo());
            newUser.setClave(bCryptEncoder.encode(registerDto.getClave()));
            newUser.setTelefono(registerDto.getTelefono());
            repo.save(newUser);

            model.addAttribute("registerDto", new RegistroDto());
            model.addAttribute("success", true);
        } catch (Exception ex) {
            result.addError(new FieldError("registerDto", "nombre", "Error inesperado: " + ex.getMessage()));
        }

        return "register"; // Mantenerse en la página de registro en todos los casos
    }
}

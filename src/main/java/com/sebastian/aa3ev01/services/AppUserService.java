package com.sebastian.aa3ev01.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sebastian.aa3ev01.models.Cliente;
import com.sebastian.aa3ev01.repositories.ClientesRepository;



@Service
public class AppUserService implements UserDetailsService {

	@Autowired
	private ClientesRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String cedula) throws UsernameNotFoundException{ 
		int cedulaInt = Integer.parseInt(cedula);
		
		Cliente  appUser = repo.findByCedula(cedulaInt);
		
		if(appUser != null) {
			
			var springUser = User.withUsername(String.valueOf(cedulaInt))
					.password(appUser.getClave())
				
					.build();
			return springUser;
		}
		return null;}
}
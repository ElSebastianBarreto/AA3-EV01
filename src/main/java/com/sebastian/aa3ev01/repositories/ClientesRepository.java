package com.sebastian.aa3ev01.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sebastian.aa3ev01.models.Cliente;



public interface ClientesRepository extends JpaRepository<Cliente, Integer> {
	
	public Cliente findByCedula(int cedula);
	

}

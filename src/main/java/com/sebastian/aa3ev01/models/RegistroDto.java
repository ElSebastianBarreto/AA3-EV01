package com.sebastian.aa3ev01.models;

import jakarta.validation.constraints.NotEmpty;

public class RegistroDto {
	private int cedula;
	private String nombre;
	private String apellido;
	private int edad;
	@NotEmpty
	private String correo;
	private String clave;
	private String confirmClave;
	private String telefono;
	public int getCedula() {
		return cedula;
	}
	public void setCedula(int cedula) {
		this.cedula = cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public String getConfirmClave() {
		return confirmClave;
	}
	public void setConfirmClave(String confirmClave) {
		this.confirmClave = confirmClave;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	

	
	
}

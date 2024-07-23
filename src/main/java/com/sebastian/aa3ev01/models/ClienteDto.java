package com.sebastian.aa3ev01.models;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ClienteDto {
	@NotNull(message = "Se requiere la cedula")
	private int cedula;
@NotEmpty(message = "Se requiere el nombre")
private String nombre;

@NotEmpty(message = "Se requiere el apellido")
private String apellido;


@Min(value = 5, message = "La edad mínima es 5")
@Max(value = 120, message = "La edad máxima es 120")
private int edad;

private String correo;
private String clave;
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
public String getTelefono() {
	return telefono;
}
public void setTelefono(String telefono) {
	this.telefono = telefono;
}



}

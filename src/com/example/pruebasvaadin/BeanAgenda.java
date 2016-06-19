package com.example.pruebasvaadin;

public class BeanAgenda {

	private int numero;
	private String nombre;
	private String telefono;
	
	public BeanAgenda() {
		super();
	}
	public BeanAgenda(int numero, String nombre, String telefono) {
		super();
		this.numero = numero;
		this.nombre = nombre;
		this.telefono = telefono;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	@Override
	public String toString() {
		return "BeanAgenda [numero=" + numero + ", nombre=" + nombre + ", telefono=" + telefono + "]";
	}
	
	
}

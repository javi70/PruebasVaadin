package com.example.tree;

public class Questionarios {


	private String id;
	private String nombre;
	private String descripcion;
	public Questionarios() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Questionarios(String id, String nombre, String descripcion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	@Override
	public String toString() {
		return "Questionarios [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + "]";
	}

	
	
	
}

package com.example.tree;

import java.util.ArrayList;

public class BDatos {

	public ArrayList<Programas> getAllProgramas(){
		ArrayList<Programas> resul = new ArrayList<Programas>();
		resul.add(new Programas("P1","Programa 1","Descripcion programa 1"));
		resul.add(new Programas("P2","Programa 2","Descripcion programa 2"));
		resul.add(new Programas("P3","Programa 3","Descripcion programa 3"));
		resul.add(new Programas("P4","Programa 4","Descripcion programa 4"));
		return resul;
	}
	
	public ArrayList<Questionarios> getAllQuestionarios(){
		ArrayList<Questionarios> resul = new ArrayList<Questionarios>();
		resul.add(new Questionarios("Q1","Questionario 1","Descripcion Questionario 1"));
		resul.add(new Questionarios("Q2","Questionario 2","Descripcion Questionario 2"));
		resul.add(new Questionarios("Q3","Questionario 3","Descripcion Questionario 3"));
		resul.add(new Questionarios("Q4","Questionario 4","Descripcion Questionario 4"));
		return resul;
	}
	
	public ArrayList<Secciones> getAllSecciones(){
		ArrayList<Secciones> resul = new ArrayList<Secciones>();
		resul.add(new Secciones("S1","Seccion 1","Descripcion Seccion 1"));
		resul.add(new Secciones("S2","Seccion 2","Descripcion Seccion 2"));
		resul.add(new Secciones("S3","Seccion 3","Descripcion Seccion 3"));
		resul.add(new Secciones("S4","Seccion 4","Descripcion Seccion 4"));
		return resul;
	}
	
	public ArrayList<Questionarios> getQuestionariosPrograma1(){
		ArrayList<Questionarios> resul = new ArrayList<Questionarios>();
		resul.add(new Questionarios("Q1","Questionario 1","Descripcion Questionario 1"));
		resul.add(new Questionarios("Q2","Questionario 2","Descripcion Questionario 2"));
		resul.add(new Questionarios("Q3","Questionario 3","Descripcion Questionario 3"));
		return resul;
	}

	public ArrayList<Secciones> getSeccionesQuestionario1(){
		ArrayList<Secciones> resul = new ArrayList<Secciones>();
		resul.add(new Secciones("S1","Seccion 1","Descripcion Seccion 1"));
		resul.add(new Secciones("S3","Seccion 3","Descripcion Seccion 3"));
		return resul;
	}

	public ArrayList<Secciones> getSeccionesQuestionario2(){
		ArrayList<Secciones> resul = new ArrayList<Secciones>();
		resul.add(new Secciones("S1","Seccion 1","Descripcion Seccion 1"));
		return resul;
	}

	public ArrayList<Secciones> getlSeccionesQuestionario3(){
		ArrayList<Secciones> resul = new ArrayList<Secciones>();
		resul.add(new Secciones("S3","Seccion 3","Descripcion Seccion 3"));
		resul.add(new Secciones("S4","Seccion 4","Descripcion Seccion 4"));
		return resul;
	}

}

package com.example.pruebasvaadin;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.DateField;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;


public class MisPruebasView extends VerticalLayout implements View {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Table tabla;	
	TextField txtFiltroNombre, txtFiltroTelefono;
	MenuSuperTabla menu;
	
	@SuppressWarnings("serial")
	public MisPruebasView(){
		
		addComponent(convertirFechaString());

		addComponent(convertirStringFecha());
		
		addComponent(cargarCombo());
		
		
	}
	
	
	private VerticalLayout convertirFechaString(){
		VerticalLayout resul=new VerticalLayout();
		Label lblFechaString = new Label("Fecha a String");
		resul.addComponent(lblFechaString);
		DateField dtFecha = new DateField();
		resul.addComponent(dtFecha);
		Label lblResul = new Label();
		resul.addComponent(lblResul);
		Button btnFechaString=new Button("Convertir");
		resul.addComponent(btnFechaString);
		
		btnFechaString.addClickListener(new Button.ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				if(dtFecha.getValue()!=null){
					lblResul.setValue(new SimpleDateFormat("dd-MM-yyyy").format(dtFecha.getValue()));
				}else{
					lblResul.setValue("La fecha está vacia");
				}
			}
		});
		return resul;
	}

	private VerticalLayout convertirStringFecha(){
		VerticalLayout resul=new VerticalLayout();
		Label lblStringFecha = new Label("String a Fecha");
		resul.addComponent(lblStringFecha);
		TextField tfFecha = new TextField();
		DateField dtResul= new DateField();
		resul.addComponent(tfFecha);
		resul.addComponent(dtResul);
		Button btnStringFecha=new Button("Convertir");
		resul.addComponent(btnStringFecha);
		
		btnStringFecha.addClickListener(new Button.ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				if(tfFecha.getValue()!=null){
					//dtResul.setValue(tfFecha.getValue());
					SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
					try {
						dtResul.setValue(formato.parse(tfFecha.getValue()));
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else{
					dtResul.setValue(new Date());
				}
			}
		});		
		return resul;
	}
	
	
	private VerticalLayout cargarCombo(){
		VerticalLayout resul = new VerticalLayout();
		
		ComboBox cmbCombo = new ComboBox();
		cmbCombo.addItem("Lunes");
		cmbCombo.addItem("Martes");
		cmbCombo.addItem("Miercoles");
		cmbCombo.addItem("Jueves");
		cmbCombo.addItem("Viernes");
		resul.addComponent(cmbCombo);
		Button btnCombo = new Button("Seleccionar");
		resul.addComponent(btnCombo);

		btnCombo.addClickListener(new Button.ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				Notification.show("Seleccionado el "+cmbCombo.getValue());
				cmbCombo.setValue("Martes");
				
			}
		});
		
		return resul;
	}
	@Override
	public void enter(ViewChangeEvent event) {
	}
	

}

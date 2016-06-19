package com.example.pruebasvaadin;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class MenuSuperTabla extends CustomComponent {
	

	public MenuSuperTabla(){
		VerticalLayout layout = new VerticalLayout();
		layout.setSizeUndefined();
		layout.addComponent(crearFilaMenuTablas("Tabla 1","listaTablas1"));
		layout.addComponent(crearFilaMenuTablas("Tabla 2","listaTablas2"));
		layout.addComponent(crearFilaMenuTablas("Tabla 3","listaTablas3"));
		setCompositionRoot(layout);
		setVisible(false);
	}
	
	private HorizontalLayout crearFilaMenuTablas(String texto,String estilo){
		HorizontalLayout resul=new HorizontalLayout();
		
		resul.setWidth("300px");
		resul.setStyleName(estilo);
		Label tabla3 = new Label(texto);
		CheckBox chk3 = new CheckBox();
		resul.addComponent(tabla3);
		resul.addComponent(chk3);
		resul.setComponentAlignment(chk3,Alignment.TOP_RIGHT);
		return resul;
	}


	
	

}

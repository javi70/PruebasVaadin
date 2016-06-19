package com.example.pruebasvaadin;

import com.vaadin.data.Item;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

public class AnalisisView2 extends VerticalLayout implements View {
	
	public AnalisisView2(){
		setSizeFull();
		
		Table tabla = new Table("Tabla");
		tabla.addContainerProperty("Numero", Integer.class, 0);
		tabla.addContainerProperty("Nombre", String.class, null);
		tabla.addContainerProperty("Telefono", String.class, null);
		
		Object newItemId=null;
		for(int i=0;i<PruebasvaadinUI.agenda.size();i++){
			System.out.println(PruebasvaadinUI.agenda.get(i).getNombre());
			newItemId = tabla.addItem();
			Item row = tabla.getItem(newItemId);
			row.getItemProperty("Numero").setValue(PruebasvaadinUI.agenda.get(i).getNumero());
			row.getItemProperty("Nombre").setValue(PruebasvaadinUI.agenda.get(i).getNombre());
			row.getItemProperty("Telefono").setValue(PruebasvaadinUI.agenda.get(i).getTelefono());
			tabla.addItem(newItemId);			
		}

		
		tabla.setPageLength(tabla.size());
		tabla.setSizeFull();
		addComponent(tabla);
		
		addComponent(new Label(tabla.size()+" elementos"));
		
	}

	
	@Override
	public void enter(ViewChangeEvent event) {
		//Notification.show("Entrando en la vista");

	}

}

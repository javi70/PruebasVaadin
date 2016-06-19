package com.example.pruebasvaadin;

import com.vaadin.annotations.Theme;
import com.vaadin.data.Item;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.Table;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import javafx.print.PageLayout;

@SuppressWarnings("serial")
@Theme("pruebasvaadin")
public class PruebasvaadinUI2 extends UI {
	
	@Override
	protected void init(VaadinRequest request) {
		final HorizontalLayout layout = new HorizontalLayout();
		layout.setMargin(true);
		layout.setSizeFull();

		VerticalLayout menuLayout = new VerticalLayout();
		menuLayout.setMargin(true);
		Button btnMantenimiento = new Button("Mantenimiento");
		btnMantenimiento.setWidth("150px");
		menuLayout.addComponent(btnMantenimiento);
		Button btnAnalisis = new Button("Análisis");
		btnAnalisis.setWidth("150px");
		menuLayout.addComponent(btnAnalisis);			
		layout.addComponent(menuLayout);

		Panel panel = new Panel("Listado de Análisis");
			TabSheet tabSheet = new TabSheet();
			panel.setContent(tabSheet);
			VerticalLayout vl = new VerticalLayout();
			vl.setSizeFull();
			
				Table tabla = new Table("Tabla");
				tabla.addContainerProperty("Numero", Integer.class, 0);
				tabla.addContainerProperty("Nombre", String.class, null);
				tabla.addContainerProperty("Telefono", String.class, null);
				
				Object newItemId1 = tabla.addItem();
				Item row1 = tabla.getItem(newItemId1);
				row1.getItemProperty("Numero").setValue(1);
				row1.getItemProperty("Nombre").setValue("Any");
				row1.getItemProperty("Telefono").setValue("646155202");
				tabla.addItem(newItemId1);
				
				Object newItemId2 = tabla.addItem();
				Item row2 = tabla.getItem(newItemId2);
				row2 = tabla.getItem(newItemId2);
				row2.getItemProperty("Numero").setValue(2);
				row2.getItemProperty("Nombre").setValue("Javi");
				row2.getItemProperty("Telefono").setValue("611450967");
				tabla.addItem(newItemId2);
				
				tabla.setPageLength(tabla.size());
				tabla.setSizeFull();
				vl.addComponent(tabla);
				
			vl.addComponent(new Label(tabla.size()+" elementos"));
				
			tabSheet.addTab(vl, "Análisis");
		
		layout.addComponent(panel);
		
		layout.setExpandRatio(menuLayout, 2);
		layout.setExpandRatio(panel, 8);
		
			
		
		setContent(layout);
		
		btnMantenimiento.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				layout.addComponent(new Label("Thank you for clicking"));
			}
		});
		
	}

}
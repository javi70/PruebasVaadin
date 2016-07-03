package com.example.pruebasvaadin;

import com.example.tree.TreeView;
import com.vaadin.data.Item;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;

public class MainView extends VerticalLayout implements View {

	HorizontalLayout layout;
	Panel panel;
	TabSheet tabSheet; 
	Navigator navigator;
	
	public MainView(Navigator navigator) {
		this.navigator = navigator;
		
		setSizeFull();

		layout= new HorizontalLayout();
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
		Button btnDatos= new Button("Datos");
		btnDatos.setWidth("150px");
		menuLayout.addComponent(btnDatos);
		Button btnSuperTabla= new Button("SuperTabla");
		btnSuperTabla.setWidth("150px");
		menuLayout.addComponent(btnSuperTabla);
		Button btnMisPruebas= new Button("Mis pruebas");
		btnMisPruebas.setWidth("150px");
		menuLayout.addComponent(btnMisPruebas);					
		Button btnTree= new Button("Tree view");
		btnTree.setWidth("150px");
		menuLayout.addComponent(btnTree);					

		layout.addComponent(menuLayout);
		
		panel = new Panel("PANEL");
			tabSheet = new TabSheet();
			panel.setContent(tabSheet);
			cargarMantenimiento();
			cargarAnalisis();
			
		layout.addComponent(panel);
		
		layout.setExpandRatio(menuLayout, 2);
		layout.setExpandRatio(panel, 8);
		
		btnMantenimiento.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				cargarMantenimiento();				
			}
		});
		
		btnAnalisis.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				cargarAnalisis();
			}
		});

		btnDatos.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				cargarDatos();
			}
		});

		btnSuperTabla.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				cargarSuperTabla();
			}
		});
		
		btnMisPruebas.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				cargarMisPruebas();
			}
		});
		
		btnTree.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				cargarTree();
			}
		});
		addComponent(layout);
		
		
	}
	
	@Override
	public void enter(ViewChangeEvent event) {
		Notification.show("Main View");

	}

	private void cargarAnalisis(){
		tabSheet.removeAllComponents();
		VerticalLayout vla = new AnalisisView();		
		tabSheet.addTab(vla, "Análisis");
		VerticalLayout vlm = new MantenimientoView(navigator);
		tabSheet.addTab(vlm,"Mantenimiento");
		VerticalLayout vld = new DatosView(navigator);
		tabSheet.addTab(vld,"Datos");
		Layout vlst = new SuperTablaView();
		tabSheet.addTab(vlst,"SuperTabla");
		Layout vltree = new TreeView();
		tabSheet.addTab(vltree,"Tree");
		
		tabSheet.setSelectedTab(vla);
	}
	
	private void cargarMantenimiento(){
		tabSheet.removeAllComponents();
		VerticalLayout vla = new AnalisisView();		
		tabSheet.addTab(vla, "Análisis");
		VerticalLayout vlm = new MantenimientoView(navigator);
		tabSheet.addTab(vlm,"Mantenimiento");
		VerticalLayout vld = new DatosView(navigator);
		tabSheet.addTab(vld,"Datos");
		Layout vlst = new SuperTablaView();
		tabSheet.addTab(vlst,"SuperTabla");
		Layout vltree = new TreeView();
		tabSheet.addTab(vltree,"Tree");
		
		tabSheet.setSelectedTab(vlm);
	}

	private void cargarDatos(){
		tabSheet.removeAllComponents();
		VerticalLayout vla = new AnalisisView();		
		tabSheet.addTab(vla, "Análisis");
		VerticalLayout vlm = new MantenimientoView(navigator);
		tabSheet.addTab(vlm,"Mantenimiento");
		VerticalLayout vld = new DatosView(navigator);
		tabSheet.addTab(vld,"Datos");
		Layout vlst = new SuperTablaView();
		tabSheet.addTab(vlst,"SuperTabla");
		Layout vltree = new TreeView();
		tabSheet.addTab(vltree,"Tree");
		
		tabSheet.setSelectedTab(vld);
	
	}
	
	private void cargarSuperTabla(){
		tabSheet.removeAllComponents();
		VerticalLayout vla = new AnalisisView();		
		tabSheet.addTab(vla, "Análisis");
		VerticalLayout vlm = new MantenimientoView(navigator);
		tabSheet.addTab(vlm,"Mantenimiento");
		VerticalLayout vld = new DatosView(navigator);
		tabSheet.addTab(vld,"Datos");
		Layout vlst = new SuperTablaView();
		tabSheet.addTab(vlst,"SuperTabla");
		Layout vltree = new TreeView();
		tabSheet.addTab(vltree,"Tree");
		
		tabSheet.setSelectedTab(vlst);
	
	}
	
	private void cargarMisPruebas(){
		tabSheet.removeAllComponents();
		VerticalLayout vla = new AnalisisView();		
		tabSheet.addTab(vla, "Análisis");
		VerticalLayout vlm = new MantenimientoView(navigator);
		tabSheet.addTab(vlm,"Mantenimiento");
		VerticalLayout vld = new DatosView(navigator);
		tabSheet.addTab(vld,"Datos");
		Layout vlst = new SuperTablaView();
		tabSheet.addTab(vlst,"SuperTabla");		
		Layout vlmp = new MisPruebasView();
		tabSheet.addTab(vlmp,"MisPruebas");
		Layout vltree = new TreeView();
		tabSheet.addTab(vltree,"Tree");
		
		tabSheet.setSelectedTab(vlmp);
	
	}
	
	private void cargarTree(){
		tabSheet.removeAllComponents();
		VerticalLayout vla = new AnalisisView();		
		tabSheet.addTab(vla, "Análisis");
		VerticalLayout vlm = new MantenimientoView(navigator);
		tabSheet.addTab(vlm,"Mantenimiento");
		VerticalLayout vld = new DatosView(navigator);
		tabSheet.addTab(vld,"Datos");
		Layout vlst = new SuperTablaView();
		tabSheet.addTab(vlst,"SuperTabla");		
		Layout vlmp = new MisPruebasView();
		tabSheet.addTab(vlmp,"MisPruebas");
		Layout vltree = new TreeView();
		tabSheet.addTab(vltree,"Tree");
		
		tabSheet.setSelectedTab(vltree);
	
	}
	
}

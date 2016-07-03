/**
 * Crea un arbol con la siguiente estructura
 * Programa 1
 * 	Questionario 1
 * 		Seccion 1
 * 		Seccion 3
 * 	Questionario 2
 * 	Questionario 3
 * Programa 2
 * Programa 3
 * Programa 4
 * 
 * 
 * Al hacer addItem(x), la x es el valor del id, no el item
 * Los ID de los elementos no deben ser iguales (el setparent no funcionaria)
 * setParent(valor del id del hijo , valor del id del padre)
 * 
 * 
 */

package com.example.tree;

import com.vaadin.data.Container;
import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.data.util.HierarchicalContainer;
import com.vaadin.event.Action.Handler;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.AbstractSelect.ItemCaptionMode;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.Table;
import com.vaadin.ui.Tree;
import com.vaadin.ui.VerticalLayout;

public class TreeView extends CssLayout implements View {

	private static final long serialVersionUID = 1L;
	VerticalLayout vl;
	Tree tree;
	HierarchicalContainer container;
	BDatos bd ;
	Item itemId,itemIdQuestionario,itemIdSeccion;
	
	public TreeView(){
		vl= new VerticalLayout();
		Label lblTitulo = new Label("Tree View");
		vl.addComponent(lblTitulo);
//		creaTreeEjemplo();
		
		crearTree();
		crearContenedor(); 

		vl.addComponent(tree);
		addComponent(vl);		
	}

	private void creaTreeEjemplo(){
		Tree menu = new Tree();
		for (int i = 1; i < 6; i++) {
			String item = "item" + i;
			String childItem = "subitem" + i;
			menu.addItem(item);
			menu.addItem(childItem);
			menu.setParent(childItem, item);
			menu.setChildrenAllowed(childItem, false);
		}
		vl.addComponent(menu);
	}
	

	
	private void crearTree(){
		
		// Create the Tree, add to layout
        tree= new Tree("PROGRAMAS");
        tree.setImmediate(true);

        // Set tree to show the 'name' property as caption for items
        tree.setItemCaptionPropertyId("nombre");
     
        tree.addValueChangeListener(e -> Notification.show("Value changed:",String.valueOf(e.getProperty().getValue()),Type.TRAY_NOTIFICATION));
	}
        
	@Override
	public void enter(ViewChangeEvent event) {
	}
	
	
	@SuppressWarnings("unchecked")
	private void crearContenedor(){
		// Create a container
		container = new HierarchicalContainer();
		
		// Define the properties (columns) if required by container
		container.addContainerProperty("id", String.class,null);
		container.addContainerProperty("nombre", String.class, null);
		container.addContainerProperty("descripcion", String.class,null);

		//... add items ...
		
		bd = new BDatos();
		for(int i=0;i<bd.getAllProgramas().size();i++){
			Programas programa = bd.getAllProgramas().get(i);
			itemId = container.addItem(programa.getId());
			itemId.getItemProperty("id").setValue(programa.getId());
			itemId.getItemProperty("nombre").setValue(programa.getNombre());
			itemId.getItemProperty("descripcion").setValue(programa.getDescripcion());
			if(i==0){
				cargarQuestionariosDePrograma(itemId);
			}else container.setChildrenAllowed(itemId,false);
		}
		
		// Bind it to a component
		tree.setContainerDataSource(container);
		

	}

	@SuppressWarnings("unchecked")
	private void cargarQuestionariosDePrograma(Item itemPadre){
		for(int j=0;j<bd.getQuestionariosPrograma1().size();j++){
			Questionarios quest= bd.getQuestionariosPrograma1().get(j);
			itemIdQuestionario = container.addItem(quest.getId());
			itemIdQuestionario.getItemProperty("id").setValue(quest.getId());
			itemIdQuestionario.getItemProperty("nombre").setValue(quest.getNombre());
			itemIdQuestionario.getItemProperty("descripcion").setValue(quest.getDescripcion());
			container.setChildrenAllowed(itemPadre,true);
			container.setParent(itemIdQuestionario.getItemProperty("id").getValue(),itemPadre.getItemProperty("id").getValue());
			container.setChildrenAllowed(itemIdQuestionario.getItemProperty("id"), false);
			if(j==0){
				cargarSeccionesQuestionario(itemIdQuestionario);
			}
	
		}
	}
	
	@SuppressWarnings("unchecked")
	private void cargarSeccionesQuestionario(Item itemPadre){
		for(int k=0;k<bd.getSeccionesQuestionario1().size();k++){
			Secciones sec= bd.getSeccionesQuestionario1().get(k);
			itemIdSeccion = container.addItem(sec.getId());
			itemIdSeccion.getItemProperty("id").setValue(sec.getId());
			itemIdSeccion.getItemProperty("nombre").setValue(sec.getNombre());
			itemIdSeccion.getItemProperty("descripcion").setValue(sec.getDescripcion());
			container.setParent(itemIdSeccion.getItemProperty("id").getValue(),itemPadre.getItemProperty("id").getValue());
			container.setChildrenAllowed(itemIdSeccion, false);
		}
	}
}

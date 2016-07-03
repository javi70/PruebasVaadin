package com.example.pruebasvaadin;

import com.vaadin.data.Container;
import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.data.util.HierarchicalContainer;
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

public class TreeView1 extends CssLayout implements View {

	private static final long serialVersionUID = 1L;
	VerticalLayout vl;
	Tree tree;
	Container container;
	
	public TreeView1(){
		vl= new VerticalLayout();
		Label lblTitulo = new Label("Tree View");
		vl.addComponent(lblTitulo);
		crearTree();
		crearContenedor();
		addComponent(vl);		
	}

	private void crearTree(){
		
		// Create the Tree, add to layout
        tree= new Tree("Agenda");
        tree.addContainerProperty("numero", String.class,null);
        tree.setImmediate(true);

        // Set tree to show the 'name' property as caption for items
        tree.setItemCaptionPropertyId("nombre");

        // Expand whole tree
        for (final Object id : tree.rootItemIds()) {
        	tree.expandItemsRecursively(id);
        }
        
        vl.addComponent(tree);        
        tree.addValueChangeListener(e -> Notification.show("Value changed:",String.valueOf(e.getProperty().getValue()),Type.TRAY_NOTIFICATION));
	}
        
	@Override
	public void enter(ViewChangeEvent event) {
	}
	
	private void ejemploTabla(){
		// Create a table with one column
		Table table = new Table("My Table");
		table.addContainerProperty("col1", String.class, null);
	
	
		// Access items and properties through the component
		table.addItem("row1"); // Create item by explicit ID
		Item item1 = table.getItem("row1");
		Property property1 = item1.getItemProperty("col1");
		property1.setValue("some given value");
	
	
		// Equivant access through the container
		Container container = table.getContainerDataSource();
		container.addItem("row2");
		Item item2 = container.getItem("row2");
		Property property2 = item2.getItemProperty("col1");
		property2.setValue("another given value");	
		vl.addComponent(table);
	}
	
	private void crearContenedor(){
		// Create a container
		container = new HierarchicalContainer();
		
		// Define the properties (columns) if required by container
		container.addContainerProperty("numero", Integer.class,null);
		container.addContainerProperty("nombre", String.class, null);
		container.addContainerProperty("telefono", String.class,null);

		//... add items ...
		for(int i=0;i<PruebasvaadinUI.agenda.size();i++){
			BeanAgenda agenda = PruebasvaadinUI.agenda.get(i);
			Item itemId = container.addItem((agenda));
			itemId.getItemProperty("numero").setValue(agenda.getNumero());
			itemId.getItemProperty("nombre").setValue(agenda.getNombre());
			itemId.getItemProperty("telefono").setValue(agenda.getTelefono());
		}
	
		// Bind it to a component
		tree.setContainerDataSource(container);
	}
}

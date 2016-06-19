package com.example.pruebasvaadin;
import com.vaadin.data.Container.Filterable;
import com.vaadin.data.Item;
import com.vaadin.data.util.filter.SimpleStringFilter;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class AnalisisView extends VerticalLayout implements View {

	SimpleStringFilter filter = null;
	Table tabla;	
	TextField txtFiltroNombre, txtFiltroTelefono;
	Button btnFiltrar, btnBorrarFiltros;
	Filterable f ;
	
	public AnalisisView(){
		setSizeFull();
		
		HorizontalLayout hlFiltro = new HorizontalLayout();
			txtFiltroNombre = new TextField();
			txtFiltroTelefono = new TextField();
			btnFiltrar = new Button("Filtrar");
			btnBorrarFiltros = new Button("Borrar filtros");
			
			hlFiltro.addComponent(txtFiltroNombre);
			hlFiltro.addComponent(txtFiltroTelefono);
			hlFiltro.addComponent(btnFiltrar);
			hlFiltro.addComponent(btnBorrarFiltros);
		addComponent(hlFiltro);
		
		tabla = new Table("Tabla");
		tabla.addContainerProperty("Numero", Integer.class, 0);
		tabla.addContainerProperty("Nombre", String.class, null);
		tabla.addContainerProperty("Telefono", String.class, null);
		
		Object newItemId=null;
		for(int i=0;i<PruebasvaadinUI.agenda.size();i++){
			//System.out.println(PruebasvaadinUI.agenda.get(i).getNombre());
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
		
		btnFiltrar.addClickListener(new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				//FILTRAR
				filtrar();
			}
		});
		
		btnBorrarFiltros.addClickListener(new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				f.removeAllContainerFilters();
				txtFiltroNombre.setValue("");
				txtFiltroTelefono.setValue("");
			}
		});
	}
	
	@Override
	public void enter(ViewChangeEvent event) {
	}
	
	private void filtrar(){
		f = (Filterable) tabla.getContainerDataSource();
        
        // Remove old filter
        if (filter != null) f.removeContainerFilter(filter);
        
        // Set new filter for the "Name" column
        filter = new SimpleStringFilter("Nombre", txtFiltroNombre.getValue(), true, false);
        f.addContainerFilter(filter);				
        filter = new SimpleStringFilter("Telefono",txtFiltroTelefono.getValue(),true,false);
        f.addContainerFilter(filter);
	}
}
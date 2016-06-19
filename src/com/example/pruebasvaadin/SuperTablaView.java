package com.example.pruebasvaadin;
import com.vaadin.data.Item;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.Sizeable;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.themes.ValoTheme;

public class SuperTablaView extends CssLayout implements View {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Table tabla;	
	TextField txtFiltroNombre, txtFiltroTelefono;
	MenuSuperTabla menu;
	
	@SuppressWarnings("serial")
	public SuperTablaView(){
		setSizeFull();

		//Cabecera de la tabla
		HorizontalLayout hlCabecera = new HorizontalLayout();
		hlCabecera.addStyleName("cab-supertabla");
		hlCabecera.setSpacing(true);
		
			Label tituloCabecera = new Label("Cabecera de la tabla");
			hlCabecera.addComponent(tituloCabecera);

			Button btnOpciones = new Button(FontAwesome.COG);
	        btnOpciones.addStyleName(ValoTheme.BUTTON_QUIET);
			hlCabecera.addComponent(btnOpciones);

		addComponent(hlCabecera);

		//creo el menu aunque no se muestra
		menu= new MenuSuperTabla();
		menu.setWidth("300px");
		menu.setStyleName("menu-tabla-invisible");
		addComponent(menu);
		
		
		tabla = new Table();
		tabla.setStyleName("tabla-encima");
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
		
		btnOpciones.addClickListener(new Button.ClickListener() {
	
			@Override
			public void buttonClick(ClickEvent event) {
				System.out.println("al entrar "+menu.isVisible());
				if(menu.isVisible()){
					//mostrar/ocultar tablas
					menu.setVisible(false);
					menu.setStyleName("menu-tabla-invisible");
					tabla.setStyleName("tabla-encima");					
					Notification.show("Mostrar tablas");
				}else{				
					menu.setVisible(true);
					menu.setStyleName("menu-tabla-visible");
					tabla.setStyleName("tabla-debajo");
				}
				

				
			}
		});

	}
	
	
	
	@Override
	public void enter(ViewChangeEvent event) {
	}
	
}
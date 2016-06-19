package com.example.pruebasvaadin;

import com.vaadin.data.util.ObjectProperty;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;

public class MantenimientoView extends VerticalLayout implements View {
	
	
	private FormLayout formLayout;
	private TextField numero;
	private TextField nombre;
	private TextField telefono;
	private Label lbl;
	private HorizontalLayout hlBotones; 
    	
	public MantenimientoView(Navigator navigator) {
		setSizeFull();
		
		//addComponent(new Label("ZONA EN OBRAS"));
		formLayout = new FormLayout();
		formLayout.setMargin(true);
		
			numero = new TextField("Número","");
			nombre = new TextField("Nombre", "");
		    
		    telefono = new TextField("Teléfono","");
		    
		    lbl=new Label();
		    formLayout.addComponent(lbl);
		    
		    hlBotones = new HorizontalLayout();
			    Button btnGrabar = new Button("Grabar");
			    Button btnCancelar=new Button("Cancelar");
		    hlBotones.addComponent(btnGrabar);
		    hlBotones.addComponent(btnCancelar);
		    
	    formLayout.addComponent(numero);
	    formLayout.addComponent(nombre);
	    formLayout.addComponent(telefono);
	    formLayout.addComponent(hlBotones);
		    
	    addComponent(formLayout);

	    btnGrabar.addClickListener(new Button.ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				PruebasvaadinUI.agenda.add(PruebasvaadinUI.agenda.size(),new BeanAgenda(Integer.parseInt(numero.getValue()),nombre.getValue(),telefono.getValue()));
				for(int i=0;i<PruebasvaadinUI.agenda.size();i++){
					System.out.println(PruebasvaadinUI.agenda.get(i).toString());
				}
				Notification.show("Registro añadido");
			}
		});
	    
	    btnCancelar.addClickListener(new Button.ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				limpiarCampos();
				
			}
		});
	    //ObjectProperty<String> propNumero = new ObjectProperty<String>("value");
	    ObjectProperty propNumero = new ObjectProperty(numero.getData(), String.class);
	    numero.setPropertyDataSource(propNumero);
	    lbl.setPropertyDataSource(propNumero);
	}

	@Override
	public void enter(ViewChangeEvent event) {

	}

	private void limpiarCampos(){
		numero.setValue("");
		nombre.setValue("");
		telefono.setValue("");
	}
}

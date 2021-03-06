package com.example.pruebasvaadin;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.data.util.ObjectProperty;
import com.vaadin.data.util.converter.StringToDateConverter;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.shared.ui.ui.UIState.LocaleData;
import com.vaadin.ui.AbstractSelect.ItemCaptionMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.DateField;

public class DatosView extends VerticalLayout implements View {

		
		private FormLayout formLayout;
		private TextField numero;
		private ComboBox nombre;
		private TextField telefono;
		private DateField fecha;
		private Label lbl;
		private HorizontalLayout hlBotones; 
	    	
		@SuppressWarnings({ "unchecked", "rawtypes" })
		public DatosView(Navigator navigator) {
			setSizeFull();
			
			//addComponent(new Label("ZONA EN OBRAS"));
			formLayout = new FormLayout();
			formLayout.setMargin(true);
			
				numero = new TextField("N�mero","0");
				
				fecha = new DateField("Fecha");

		        BeanItemContainer<BeanAgenda> container = new BeanItemContainer<BeanAgenda>(BeanAgenda.class);
				nombre = new ComboBox("Nombre",container);
	    		nombre.setItemCaptionMode(ItemCaptionMode.PROPERTY);
	    		nombre.setItemCaptionPropertyId("nombre");
				
			    telefono = new TextField("Tel�fono","");
			    
			    lbl=new Label();
			    formLayout.addComponent(lbl);
			    
			    hlBotones = new HorizontalLayout();
				    Button btnGrabar = new Button("Grabar");
				    Button btnCancelar=new Button("Cancelar");
			    hlBotones.addComponent(btnGrabar);
			    hlBotones.addComponent(btnCancelar);
			    
		    formLayout.addComponent(numero);
		    formLayout.addComponent(fecha);
		    formLayout.addComponent(nombre);
		    formLayout.addComponent(telefono);
		    formLayout.addComponent(hlBotones);
			    
		    addComponent(formLayout);

		    
		    btnGrabar.addClickListener(new Button.ClickListener() {
				
				@Override
				public void buttonClick(ClickEvent event) {
					PruebasvaadinUI.agenda.add(PruebasvaadinUI.agenda.size(),new BeanAgenda(Integer.parseInt(numero.getValue()),null,telefono.getValue()));
					for(int i=0;i<PruebasvaadinUI.agenda.size();i++){
						System.out.println(PruebasvaadinUI.agenda.get(i).toString());
					}
					
					Notification.show("Registro a�adido. La fecha es "+new SimpleDateFormat("dd-MM-yyyy").format(fecha.getValue()));
					StringToDateConverter conversor = new StringToDateConverter();
					String strFecha="01/06/2016";
					Class<? extends Date> dtFecha=null;
					System.out.println(conversor.convertToModel(strFecha, dtFecha, Locale.getDefault()));
					System.out.println(dtFecha);
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


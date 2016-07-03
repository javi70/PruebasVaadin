package com.example.pruebasvaadin;

import java.util.ArrayList;

import com.example.tree.TreeView;
import com.vaadin.annotations.Theme;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
@Theme("pruebasvaadin")
public class PruebasvaadinUI extends UI {

	private VerticalLayout pageLayout;	
	static public ArrayList<BeanAgenda> agenda; 
	private Navigator navigator;
	
	@Override
	protected void init(VaadinRequest request) {
		final HorizontalLayout layout = new HorizontalLayout();
		layout.setMargin(true);
		layout.setSizeFull();
		
		setContent(layout);
		
		crearAgenda();
		
		navigator = new Navigator(this, layout);
		navigator.addView("", new MainView(navigator));
		navigator.addView("analisis", new AnalisisView());
		navigator.addView("mantenimiento", new MantenimientoView(navigator));
		navigator.addView("datos", new DatosView(navigator));
		navigator.addView("supertabla", new SuperTablaView());
		navigator.addView("tree", new TreeView());
		navigator.navigateTo("");
		

	}

	private void crearAgenda(){
		agenda = new ArrayList<BeanAgenda>();
		agenda.add(new BeanAgenda(1,"Any","646155202"));
		agenda.add(new BeanAgenda(2,"Javi","611450967"));
		agenda.add(new BeanAgenda(3,"Casa","944315080"));
		
		agenda.add(new BeanAgenda(4,"Nagore","628111222"));
		agenda.add(new BeanAgenda(5,"Beto","0052 611450967"));
		agenda.add(new BeanAgenda(6,"Lili","0052 944315080"));
	}
}
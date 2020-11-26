package GUI;

import java.util.List;

import Logica.*;

public class ControlEntidades implements Runnable{
	protected List<Entidad> entidades;
	protected GUIJuego gui;
	protected static ControlEntidades control;
	
	public ControlEntidades(GUIJuego gui) {
		this.gui = gui;
		entidades = Juego.instancia().getEntidades();
	}
	
	/*
	public static ControlEntidades instancia() {
		if(control == null) {
			control = new ControlEntidades();
		}
		return control;
	}
	*/
	
	@Override
	public void run() {
		//TODO Auto-generated method stub
		try {
			Thread.sleep(1000);
			for(Entidad entidad : entidades) {
				entidad.jugar();
				gui.actualizar(entidad.getEntidadGrafica().getGrafico().toString(), entidad.getEntidadGrafica());
				System.out.println(entidad.getEntidadGrafica().getGrafico().toString());
			}
		}
		catch(InterruptedException e) {}
		
	}
}

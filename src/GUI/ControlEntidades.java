package GUI;

import java.util.List;

import Logica.*;

public class ControlEntidades implements Runnable{
	protected List<Entidad> entidades;
	protected GUIJuego gui;
	protected static ControlEntidades control;
	
	private ControlEntidades() {
		entidades = gui.getJuego().getEntidades();
	}
	
	public static ControlEntidades instancia() {
		if(control == null) {
			control = new ControlEntidades();
		}
		return control;
	}
	
	@Override
	public void run() {
		//TODO Auto-generated method stub
		for(Entidad entidad : entidades)
			entidad.jugar();
	}
	
	/*
	protected void mover(Infectado infectado){
		int movimiento, index;
		JLabel labelInfectado;
		index = infectados.indexOf(infectado);
		labelInfectado = labelsInfectados.get(index);
		movimiento = labelInfectado.getY() + infectado.getVelocidad();
		if(movimiento < gui.getPanelMapa().getHeight()) {
			labelInfectado.setBounds(labelInfectado.getX(), movimiento, 90, 100);
		}	
		else if (infectado.getCargaViral()<=0){
			gui.getJuego().getNivel().eliminarInfectado(infectado);
			labelInfectado.setVisible(false);
			labelsInfectados.remove(labelInfectado);
		}
		else {
			labelInfectado.setBounds(labelInfectado.getX(), 0, 90, 100);
		}	
	}
	*/
	
	/*
	while(!infectados.isEmpty()) {
		Infectado infectado = ((LinkedList<Infectado>) infectados).getFirst();
		Infectado siguiente, ultimo;
		int index;
		ultimo = ((LinkedList<Infectado>) infectados).getLast();
		while(infectado != ultimo) {
			index = infectados.indexOf(infectado);
			siguiente = infectados.get(index+1);
			mover(infectado);
			infectado = siguiente;
		}
		if(infectado==ultimo)
			mover(infectado);
	}
	*/
}

package GUI;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Logica.Infectado;

public class ControlInfectados implements Runnable{
	protected static String[] rutasAlpha = {"ALPHA1Infectado.png", "ALPHA1Desinfectado.png", "ALPHA1Comun.png",
			"ALPHA2Infectado.png", "ALPHA2Desinfectado.png", "ALPHA2Comun.png"};
	protected static String[] rutasBeta = {"BETA1Infectado.png", "BETA1Desinfectado.png", "BETA1Comun.png", 
			"BETA2Infectado.png", "BETA2Desinfectado.png", "BETA2Comun.png"};
	protected GUIJuego gui;
	protected List<JLabel> labelsInfectados;
	protected List<Infectado> infectados; //NUEVO
	
	public ControlInfectados(GUIJuego gui) {
		this.gui = gui;
		infectados = gui.getJuego().getNivel().getInfectados();
	}

	@Override
	public void run() {
		labelsInfectados = new LinkedList<JLabel>();
		
		try {
			for(Infectado infectado : infectados) {
				labelsInfectados.add(new JLabel(""));
				cargar(infectado, ((LinkedList<JLabel>) labelsInfectados).getLast());
								
				Thread.sleep(3000);
				
				for(JLabel labelInfectado : labelsInfectados) {
					int index = labelsInfectados.indexOf(labelInfectado);
					mover(infectados.get(index));
				}
			}
			
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
		}
		catch(InterruptedException e) {}
	}
	
	protected void cargar(Infectado infectado, JLabel labelInfectado) { 
		Random random = new Random();
		int posX;
		actualizar(infectado);
		posX = random.nextInt(gui.getPanelMapa().getWidth() - labelInfectado.getWidth());
		labelInfectado.setBounds(posX, 0, 90, 100);
		gui.actualizar(infectado.getEntidadGrafica().getImagenes()[0], labelInfectado);
		gui.getPanelMapa().add(labelInfectado, 0);
	}
	
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
		
		//actualizar la entidad gráfica del infectado
	}
	
	protected void actualizar(Infectado infectado) { //NUEVO
		Random random = new Random();
		int valor;
		String tipo = infectado.getTipo();
		String[] rutas = new String[3];
		valor = random.nextInt(2);
		if(valor==1) {
			for(int i=0; i<3; i++) {
				if(tipo.equals("Alpha")) {
					rutas[i] = rutasAlpha[i];
				}	
				else {
					rutas[i] = rutasBeta[i];
				}	
			}	
		}	
		else {
			for(int i=3; i<6; i++) {
				if(tipo.equals("Alpha")) {
					rutas[i-3] = rutasAlpha[i];
				}	
				else {
					rutas[i-3] = rutasBeta[i];
				}	
			}	
		}	
		infectado.getEntidadGrafica().setImagenes(rutas);
		infectado.getEntidadGrafica().setGrafico(new ImageIcon(rutas[0]));
	}
	
	public void cuarentena() {
		try {
			Thread.sleep(10000);
		} 
		catch (InterruptedException e) {}
	}
}
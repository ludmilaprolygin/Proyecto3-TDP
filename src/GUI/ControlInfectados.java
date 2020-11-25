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
	protected List<Infectado> infectados; 
	
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
								
				Thread.sleep(5000);
			}
		}
		catch(InterruptedException e) {}
	}
	
	protected void cargar(Infectado infectado, JLabel labelInfectado) { 
		Random random = new Random();
		int posX = random.nextInt(gui.getPanelMapa().getWidth() - labelInfectado.getWidth());
		actualizar(infectado);
		infectado.getEntidadGrafica().setPosX(posX);
		infectado.getEntidadGrafica().setPosY(0);
		labelInfectado.setBounds(posX, 0, 90, 100);
		gui.actualizar(infectado.getEntidadGrafica().getImagenes()[0], labelInfectado);
		gui.getPanelMapa().add(labelInfectado, 0);
	}
	
	public List<JLabel> getLabels(){
		return labelsInfectados;
	}
	
	protected void actualizar(Infectado infectado) {
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
package GUI;

import java.util.List;
import java.util.Random;

import javax.swing.JLabel;

import Logica.Infectado;
import Logica.Juego;

public class ControlInfectados implements Runnable{
	protected GUIJuego gui;
	protected List<Infectado> infectados; 
	
	public ControlInfectados(GUIJuego gui) {
		this.gui = gui;
		infectados = Juego.instancia().getNivel().getInfectados();
	}

	@Override
	public void run() {		
		try {
			for(Infectado infectado : infectados) {
				cargar(infectado);
								
				Thread.sleep(5000);
			}
		}
		catch(InterruptedException e) {}
	}
	
	protected void cargar(Infectado infectado) { 
		Random random = new Random();
		JLabel labelInfectado = infectado.getEntidadGrafica();
		int posX = random.nextInt(gui.getPanelMapa().getWidth() - labelInfectado.getWidth());
		infectado.getEntidadGrafica().setPosX(posX);
		infectado.getEntidadGrafica().setPosY(0);
		labelInfectado.setBounds(posX, 0, 90, 100);
		gui.actualizar(infectado.getEntidadGrafica().getImagenes()[0], labelInfectado);
		gui.getPanelMapa().add(labelInfectado, 0);
	}
	
	public void cuarentena() {
		try {
			Thread.sleep(10000);
		} 
		catch (InterruptedException e) {}
	}
}
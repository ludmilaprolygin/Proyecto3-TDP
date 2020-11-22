package GUI;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import javax.swing.JLabel;

public class ControlInfectados implements Runnable{
	protected static String[] rutas = {"ALPHA1Infectado.png", "ALPHA2Infectado.png", "BETA1Infectado.png", "BETA2Infectado.png"};
	protected GUIJuego gui;
	protected List<JLabel> labelsInfectados;
	//protected List<Infectado> infectados; ????
	
	public ControlInfectados(GUIJuego gui) {
		this.gui = gui;
		//infectados = gui.getJuego().getNivel().getInfectados();
	}

	@Override
	public void run() {
		int contadorInfectados = 0;
		int limiteInfectados = gui.getJuego().getNivel().getCantidadTanda();
		labelsInfectados = new LinkedList<JLabel>();
		
		try {
			while(contadorInfectados < limiteInfectados) {
				labelsInfectados.add(new JLabel(""));
				cargar(((LinkedList<JLabel>) labelsInfectados).getLast());
				contadorInfectados++;
								
				Thread.sleep(3000);
				
				for(JLabel labelInfectado : labelsInfectados)
					mover(labelInfectado);
			}
			
			while(gui.getJuego().getNivel().tieneInfectados()) {
				Thread.sleep(3000);
				for(JLabel labelInfectado : labelsInfectados)
					mover(labelInfectado);
			}
		}
		catch(InterruptedException e) {}
	}
	
	protected void cargar(JLabel labelInfectado) { //NUEVO
		Random random = new Random();
		int valor, posX;
		valor = random.nextInt(4);
		posX = random.nextInt(gui.getPanelMapa().getWidth()- labelInfectado.getWidth());
		labelInfectado.setBounds(posX, 0, 90, 100);
		gui.actualizar(rutas[valor], labelInfectado);
		gui.getPanelMapa().add(labelInfectado, 0);
	}
	
	protected void mover(JLabel infectado){
		int movimiento = infectado.getY() + 15;
		if(movimiento < gui.getPanelMapa().getHeight())
			infectado.setBounds(infectado.getX(), movimiento, 90, 100);
		else
			infectado.setBounds(infectado.getX(), 0, 90, 100);
		//actualizar la entidad gráfica del infectado
	}
	
	//Ver que onda cuando muere el chaboncín
	
	public void cuarentena() { //NUEVO
		try {
			Thread.sleep(10000);
		} 
		catch (InterruptedException e) {}
	}
}

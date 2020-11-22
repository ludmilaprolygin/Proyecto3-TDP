package GUI;

import java.util.Random;
import javax.swing.JLabel;

public class ControlInfectados implements Runnable{
	protected static String[] rutas = {"ALPHA1Infectado.png", "ALPHA2Infectado.png", "BETA1Infectado.png", "BETA2Infectado.png"};
	protected GUIJuego gui;
	protected JLabel[] infectados;
	
	public ControlInfectados(GUIJuego gui) {
		this.gui = gui;
	}

	@Override
	public void run() {
		Random random = new Random();
		int valor, posX;
		int contadorInfectados = 0;
		int limiteInfectados = gui.getJuego().getNivel().getCantidadTanda();
		infectados = new JLabel[limiteInfectados];
		
		try {
			while(contadorInfectados < limiteInfectados) {
				infectados[contadorInfectados] = new JLabel("");
				valor = random.nextInt(4);
				posX = random.nextInt(gui.getPanelMapa().getWidth()- infectados[contadorInfectados].getWidth());
				infectados[contadorInfectados].setBounds(posX, 0, 90, 100);
				gui.actualizar(rutas[valor], infectados[contadorInfectados]);
				gui.getPanelMapa().add(infectados[contadorInfectados], 0);
				contadorInfectados++;
								
				Thread.sleep(3000);
				
				for(int i=0; i<contadorInfectados; i++) {
					mover(infectados[i]);
				}
			}
			
			while(gui.getJuego().getNivel().tieneInfectados()) {
				Thread.sleep(3000);
				for(int i=0; i<contadorInfectados; i++) 
					mover(infectados[i]);
			}
		}
		catch(InterruptedException e) {}
	}
	
	protected void mover(JLabel infectado){
		int movimiento = infectado.getY() + 15;
		if(movimiento < gui.getPanelMapa().getHeight())
			infectado.setBounds(infectado.getX(), movimiento, 90, 100);
		else
			infectado.setAlignmentY(0);
	}

}

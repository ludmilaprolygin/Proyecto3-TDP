package GUI;

import java.util.List;

import javax.swing.SwingUtilities;

import Logica.*;

public class ControlEntidades implements Runnable{
	protected List<Entidad> entidades;
	protected GUIJuego gui;
	protected static ControlEntidades control;
	
	public ControlEntidades(GUIJuego gui) {
		this.gui = gui;
	}
	
	@Override
	public void run() {
		//TODO Auto-generated method stub
		do {
			entidades = Juego.instancia().getEntidades();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for(Entidad entidad : entidades) {
	            SwingUtilities.invokeLater(() -> {
	                entidad.jugar();
	            });
            }  
        } while (true);
	}
}

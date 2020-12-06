package GUI;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import Logica.Infectado;
import Logica.Juego;

public class ControlInfectados implements Runnable{
	protected GUIJuego GUI;
	protected List<Infectado> infectados;
	private List<Infectado> infectadosAux;
	protected int cont = 0;
	
	public ControlInfectados(GUIJuego GUI) {
		this.GUI = GUI;
		infectados = Juego.instancia().getNivel().getInfectados();
		clonarLista(infectados);
	}

	@Override
	public void run() {		
		try {
			int i=0;
			Infectado infectado;
			
            while(i < infectadosAux.size() ) {
            	infectado= infectadosAux.get(i);
            	cargar(infectado);
            	Juego.instancia().addEntidad(infectado);
            	
            	if(!Juego.instancia().cuarentenaActiva())
            		Thread.sleep(4000);
            	else 
            		Thread.sleep(12000);
            	
            	i++;
            }
		}
		catch(InterruptedException e) {}
	}
	
	protected void cargar(Infectado infectado) {
		Random random = new Random();
		int posX = random.nextInt(GUI.getPanelMapa().getWidth() - infectado.getEntidadGrafica().getWidth());
		
		infectado.getEntidadGrafica().setPosX(posX);
		infectado.getEntidadGrafica().setPosY(0);
		infectado.getEntidadGrafica().setBounds(posX, 0, 90, 120);
		infectado.getEntidadGrafica().actualizar(0);
		GUI.getPanelMapa().add(infectado.getEntidadGrafica(), 1);
	}
	
	private void clonarLista(List<Infectado> lista) {
		infectadosAux = new LinkedList<Infectado>();
		for(int i=0; i< lista.size();i++) {
			infectadosAux.add(i, lista.get(i));
		}
	}
}
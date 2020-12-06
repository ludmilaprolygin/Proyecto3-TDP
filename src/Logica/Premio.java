package Logica;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;

public abstract class Premio extends Entidad{
	protected int velocidad;
	
	public Premio() {
		super();
		velocidad=30;
		String[] ruta = {"bolsa.png"};
		entidadGrafica.setImagenes(ruta);
		entidadGrafica.setGrafico(new ImageIcon(ruta[0]));
		
	}
	
	public void jugar() {
		int posInicial = entidadGrafica.getPosY();
		entidadGrafica.setPosY(posInicial + velocidad);

		if(entidadGrafica.getPosY()>600) {
			Timer timer = new Timer();
			TimerTask tarea = new TimerTask() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					Juego.instancia().removeEntidad(Premio.this);
				}	
			};
			timer.schedule(tarea,10000);
		}
	}
	
	public void aplicarEfecto() {
		Juego.instancia().getGUI().mostrarPremio(toString());
	}
	
	public int getVelocidad() {
		return velocidad;
	}
}

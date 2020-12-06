package Logica;

import java.util.List;
import java.util.LinkedList;
import java.util.Random;

public class Nivel {
	protected int nivel;
	protected int cantidadTanda;
	protected int numeroTanda;
	protected List<Infectado> infectados; 
	
	public Nivel() {
		nivel = 1;
		cantidadTanda = 7;
		numeroTanda = 1;
		setTanda();
	}
	
	//Getters
	public List<Infectado> getInfectados() {
		return infectados;
	}
	
	public int getCantidadTanda() {
		return cantidadTanda;
	}
	
	public int getNumeroTanda() {
		return numeroTanda;
	}
	
	public int getNivel() {
		return nivel;
	}
	
	public void eliminarInfectado(Infectado infectado) { 
		infectados.remove(infectado);
		Juego.instancia().removeEntidad(infectado);
	}
	
	public boolean tieneInfectados() {
		boolean toReturn = true;
		if (infectados.isEmpty())
			toReturn = false;
		return toReturn;
	}
	
	public void setTanda() {
		Random random = new Random();
		infectados = new LinkedList<Infectado>();
		int valor;
		for(int i=0; i<cantidadTanda; i++) {
			valor = random.nextInt(2);
			if(valor == 0)
				infectados.add(new Alpha(80*nivel, 10*nivel));
			else
				infectados.add(new Beta(80*nivel, 10*nivel));
		}
	}
	
	public void subirTanda() {
		numeroTanda=2;
		setTanda();
	}
	
	public void subirNivel() {
		nivel++;
		cantidadTanda += 7;
		numeroTanda = 1;
		setTanda();
	}
}

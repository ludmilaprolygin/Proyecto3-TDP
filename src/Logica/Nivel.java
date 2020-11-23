package Logica;

import java.util.List;
import java.util.LinkedList;
import java.util.Random;


public class Nivel {
	protected Juego juego;
	protected int nivel;
	protected int cantidadTanda;
	protected int numeroTanda;
	protected List<Infectado> infectados; 
	
	public Nivel(Juego juego) {
		nivel = 1;
		cantidadTanda = 10;
		numeroTanda = 1;
		this.juego = juego;
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
	
	public void eliminarInfectado(Infectado infectado) {
		infectados.remove(infectado);
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
				infectados.add(new Alpha(15*nivel, 10*nivel));
			else
				infectados.add(new Beta(15*nivel, 10*nivel));
		}
	}
	
	public void subirNivel() {
		//Thread ??? hacer un hold y mostrar por pantalla que pasó de nivel, les parece?
		nivel++;
		cantidadTanda += 10;
		numeroTanda = 1;
		setTanda();
	}
}

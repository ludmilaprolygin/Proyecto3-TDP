package Logica;

import java.util.LinkedList;
import java.util.List;

public class Juego {
	protected Nivel nivel;
	protected List<Entidad> entidades;
	protected static Juego juego;
	
	public Juego() {
		entidades = new LinkedList<Entidad>();
		nivel = new Nivel();
	}
	
	/*
	public static Juego instancia() {
		if(juego == null)
			juego = new Juego();
		return juego;
	}
	*/
	
	public Nivel getNivel() {
		return nivel;
	}
	
	public List<Entidad> getEntidades(){
		return entidades;
	}
	
	public void addEntidad(Entidad entidad) {
		entidades.add(entidad);
	}
	
	public void removeEntidad(Entidad entidad) {
		entidades.remove(entidad);
	}
}
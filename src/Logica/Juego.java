package Logica;

import java.util.LinkedList;

public class Juego {
	protected Nivel nivel;
	protected LinkedList<Entidad> entidades;
	
	public Juego() {
		entidades = new LinkedList<Entidad>();
		nivel = new Nivel(this);
	}
	
	public Nivel getNivel() {
		return nivel;
	}
}
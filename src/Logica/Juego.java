package Logica;

import java.util.LinkedList;
import java.util.List;

public class Juego {
	protected Nivel nivel;
	protected List<Entidad> entidades;
	
	public Juego() {
		entidades = new LinkedList<Entidad>();
		nivel = new Nivel(this);
	}
	
	public Nivel getNivel() {
		return nivel;
	}
	
	public List<Entidad> getEntidades(){
		return entidades;
	}
	
	public void addEntidad(Entidad entidad) {
		entidades.add(entidad);
		System.out.println("Juego.addEntidad()");
	}
	
	public void removeEntidad(Entidad entidad) {
		entidades.remove(entidad);
	}
}
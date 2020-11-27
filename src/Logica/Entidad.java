package Logica;

import java.util.List;

import GUI.EntidadGrafica;

public abstract class Entidad{
	protected EntidadGrafica entidadGrafica;
	protected Visitor visitor;
	
	public Entidad() {
		entidadGrafica = new EntidadGrafica();
		Juego.instancia().addEntidad(this);
	}
	
	public EntidadGrafica getEntidadGrafica() {
		return entidadGrafica;
	}
	
	public abstract List<Entidad> detectarColisiones();
	
	public abstract void aceptar(Visitor v);
	
	public abstract void jugar();
}

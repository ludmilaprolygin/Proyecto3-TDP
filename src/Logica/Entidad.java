package Logica;

import GUI.EntidadGrafica;

public abstract class Entidad{
	protected EntidadGrafica entidadGrafica;
	protected Visitor visitor;
	
	public Entidad() {
		entidadGrafica = new EntidadGrafica();
	}
	
	public EntidadGrafica getEntidadGrafica() {
		return entidadGrafica;
	}
	
	public Visitor getVisitor() {
		return visitor;
	}
	
	public abstract void aceptar(Visitor v);
	
	public abstract void jugar();
}

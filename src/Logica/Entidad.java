package Logica;

import GUI.EntidadGrafica;

public abstract class Entidad{
	protected EntidadGrafica entidadGrafica;
	
	public Entidad() {
		//Juego.instancia().add(this);
		entidadGrafica = new EntidadGrafica();
	}
	
	public EntidadGrafica getEntidadGrafica() {
		return entidadGrafica;
	}
	
	public abstract void jugar();
	//Ver como era la suplantación del instanceOf para esta parte
}

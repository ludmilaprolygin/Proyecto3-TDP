package Logica;

import GUI.EntidadGrafica;

public abstract class Entidad{
	protected EntidadGrafica entidadGrafica;
	
	
	public Entidad() {
		entidadGrafica = new EntidadGrafica();
	}
	
	public EntidadGrafica getEntidadGrafica() {
		return entidadGrafica;
	}
	
	//Ver como era la suplantaci�n del instanceOf para esta parte
}

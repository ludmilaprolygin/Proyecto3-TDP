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
	
	//Ver como era la suplantación del instanceOf para esta parte
}

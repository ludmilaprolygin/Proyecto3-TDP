package Logica;

public abstract class Arma { 
	protected Proyectil proyectil;
	
	public abstract void disparar();
	
	public Proyectil getProyectil() {
		return proyectil;
	}
}

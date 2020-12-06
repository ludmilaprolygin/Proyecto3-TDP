package Logica;

public abstract class Arma { 
	protected Proyectil proyectil;
	public abstract void disparar(int p);
	
	public Proyectil getProyectil() {
		return proyectil;
	}
}

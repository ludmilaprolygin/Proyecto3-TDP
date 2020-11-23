package Logica;

public abstract class Infectado extends Personaje{
	protected int rango;
	protected int daño;
	
	public Infectado(int rango, int velocidad) {
		super();
		cargaViral = 100;
		this.rango = rango;
		this.velocidad = velocidad;
	}
	
	public int getRango() {
		return rango;
	} 
	
	public int getDaño() {
		return daño;
	}
	
	public abstract String getTipo();
}

package Logica;

public abstract class Infectado extends Personaje{
	protected int rango;
	protected float velocidad;
	protected int daño;
	
	public Infectado(int rango, float velocidad) {
		super();
		cargaViral = 100;
		this.rango = rango;
		this.velocidad = velocidad;
	}
	
	public int getRango() {
		return rango;
	} 
	
	public float getVelocidad() {
		return velocidad;
	}
	
	public int getDaño() {
		return daño;
	}
	
	public void setVelocidad(float velocidad) {
		this.velocidad = velocidad;
	}
}
